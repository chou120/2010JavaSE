package club.banyuan.mbm;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.StringTokenizer;

public class HttpServerRefine {

  private static UserService userService = UserService.getInstance();

  public static void main(String[] args) throws IOException {
    ServerSocket serverSocket = new ServerSocket(5000);

    while (true) {
      System.out.println("等待浏览器");
      Socket socket = serverSocket.accept();
      InputStream inputStream = socket.getInputStream();
      BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

      Request request = Request.parse(reader);
      if (request == null) {
        System.out.println("解析失败");
        continue;
      }

      System.out.println("向浏览器写入数据");

      // 头部数据读取完毕后，回复页面文件数据之前，需要按照HTTP的格式要求，回复以下内容
      // 回复内容时，需要有一个状态编码，表示请求的结果
      // 404 资源找不到  /abcd.txt    400 bad request 请求数据异常   500 服务器异常
      // HTTP/1.1 200 OK
      // Content-Type: text/html; charset=utf-8
      // Content-Length: 1234
      //
      OutputStream outputStream = socket.getOutputStream();

      String url = request.getUrl();
      String resourcePath = "/pages";
      if ("/".equals(url)) {
        resourcePath += "/login.html";
        writeStaticResource(outputStream, resourcePath);
      } else if (url.startsWith("/css") || url.startsWith("/images") || url.startsWith("/js") || url
          .endsWith(".html")) {
        resourcePath += url;
        // 如果xxxx.html不存在，统统返回404.html 内容
        // 通过查询资源看是否为null进行判断
        if (resourcePath.endsWith(".html")
            && HttpServerRefine.class.getResource(resourcePath) == null) {
          resourcePath = "/pages/404.html";
        }

        writeStaticResource(outputStream, resourcePath);
      } else if (url.startsWith("/server")) {
        // 以/server开头的路径，都不是请求静态资源的，而是需要处理数据
        processData(outputStream, request);

      } else {
        System.out.println("路径不合法");
        continue;
      }

      socket.close();
    }

  }

  private static void processData(OutputStream outputStream, Request request) throws IOException {
    String url = request.getUrl();
    switch (url) {
      case "/server/user/login":
        Map<String, String> formData = request.getFormData();
        User user = new User();
        user.setName(formData.get("name"));
        user.setPwd(formData.get("pwd"));
        User loginUser = userService.userLogin(user);
        // 通过发送http状态码 302(重定向) + 一个新的请求路径，让浏览器收到回复后立即发送一个新的请求到新的路径上
        if (loginUser == null) {
          // 登录失败， 跳转回login.html
          setRedirect(outputStream, request, "/login.html");
          // http://127.0.0.1:5000/login.html
        } else {
          // 登录成功， 跳转到bill_list.html 页面
          setRedirect(outputStream, request, "/user_list.html");
        }


    }
  }

  private static void setRedirect(OutputStream outputStream, Request request, String s)
      throws IOException {
    outputStream.write("HTTP/1.1 302 Found\n".getBytes());
    outputStream
        .write(("Location: " + "http://" + request.getHost() + s).getBytes());
    outputStream.write("\n".getBytes());
  }

  private static void writeStaticResource(OutputStream outputStream, String resourcePath)
      throws IOException {
    BufferedInputStream bufferedInputStream = new BufferedInputStream(
        HttpServerRefine.class.getResourceAsStream(resourcePath));
    int available = bufferedInputStream.available();

    outputStream.write("HTTP/1.1 200 OK\n".getBytes());
    // 只有html文件需要增加这句话
    if (resourcePath.endsWith(".html")) {
      outputStream.write("Content-Type: text/html; charset=utf-8\n".getBytes());
    }
    outputStream.write(("Content-Length: " + available + "\n").getBytes());
    outputStream.write("\n".getBytes());

    byte[] buf = new byte[1024];

    int count = bufferedInputStream.read(buf);
    while (count > 0) {
      outputStream.write(buf, 0, count);
      count = bufferedInputStream.read(buf);
    }

    bufferedInputStream.close();
  }
}
