package club.banyuan.mbm;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.StringTokenizer;

public class HttpServerDemo {

  public static void main(String[] args) throws IOException {
    ServerSocket serverSocket = new ServerSocket(5000);

    while (true) {
      System.out.println("等待浏览器");
      Socket socket = serverSocket.accept();
      InputStream inputStream = socket.getInputStream();
      BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

      // 读取第一行，获取请求路径
      String url = reader.readLine();
      if (url != null && url.length() > 0) {
        StringTokenizer tokenizer = new StringTokenizer(url);
        tokenizer.nextToken();
        url = tokenizer.nextToken();
        System.out.println("=============");
        System.out.println("请求路径是:" + url);
      } else {
        System.out.println("资源路径不合法");
        continue;
      }

      // GET / HTTP/1.1
      // GET 表示浏览器发送的HTTP请求方式
      String line = reader.readLine();
      int contentLength = 0;
      // 判断头部信息结束，读取到空行，表示头部信息读取完毕
      // 读取头部信息的时候，有两种情况，如果头部信息中包含 Content-Length: 22 并且其中的值不为0
      // 则需要在头部信息读取完毕后，根据长度，再从流中读取指定长度的字符
      while (line != null && line.length() != 0) {
        System.out.println(line);
        if (line.startsWith("Content-Length: ")) {
          // 如果包含了数据长度信息，解析数值
          contentLength = Integer.parseInt(line.replaceAll("Content-Length: ", ""));
        }
        line = reader.readLine();
      }

      System.out.println("读取头部结束");

      if (contentLength > 0) {
        char[] buf = new char[contentLength];
        int count = reader.read(buf);
        if (count != contentLength) {
          throw new RuntimeException("读取数据失败，长度不匹配," + count + ":" + contentLength);
        }
        String reqData = new String(buf);
        System.out.println(reqData);
        // name=%E4%B8%80%E4%BA%8C%E4%B8%89%E5%9B%9B&pwd=123456 将这种格式的数据，解码为中文字符
        reqData = URLDecoder.decode(reqData, StandardCharsets.UTF_8);
        System.out.println("请求发送的数据：");
        System.out.println(reqData);
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

      String resourcePath = "/pages";
      if ("/".equals(url)) {
        resourcePath += "/login.html";
      } else if (url.startsWith("/css") || url.startsWith("/images") || url.startsWith("/js") || url
          .endsWith(".html")) {
        resourcePath += url;
        // 如果xxxx.html不存在，统统返回404.html 内容
        // 通过查询资源看是否为null进行判断
        if (resourcePath.endsWith(".html")
            && HttpServerDemo.class.getResource(resourcePath) == null) {
          resourcePath = "/pages/404.html";
        }

        // BufferedInputStream bufferedInputStream = new BufferedInputStream(
        //     HttpServerDemo.class.getResourceAsStream("/pages/css/style.css"));
      } else {
        System.out.println("路径不合法");
        continue;
      }

      BufferedInputStream bufferedInputStream = new BufferedInputStream(
          HttpServerDemo.class.getResourceAsStream(resourcePath));
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
      socket.close();
    }

  }
}
