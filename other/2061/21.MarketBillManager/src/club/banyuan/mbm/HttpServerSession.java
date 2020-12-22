package club.banyuan.mbm;

import club.banyuan.mbm.util.MbmSession;
import club.banyuan.mbm.util.SessionUtil;
import com.alibaba.fastjson.JSONObject;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class HttpServerSession {

  private static final UserService userService = UserService.getInstance();

  public static void main(String[] args) throws IOException {
    ServerSocket serverSocket = new ServerSocket(9900);

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
        writeStaticResource(outputStream, resourcePath, request);
      } else if (url.startsWith("/css") || url.startsWith("/images") || url.startsWith("/js") || url
          .endsWith(".html")) {
        resourcePath += url;
        // 如果xxxx.html不存在，统统返回404.html 内容
        // 通过查询资源看是否为null进行判断
        if (resourcePath.endsWith(".html")
            && HttpServerJson.class.getResource(resourcePath) == null) {
          resourcePath = "/pages/404.html";
        }

        writeStaticResource(outputStream, resourcePath, request);
      } else if (url.startsWith("/server")) {
        // 以/server开头的路径，都不是请求静态资源的，而是需要处理数据
        try {
          processData(outputStream, request);
        } catch (BadRequestException e) {
          sendBadRequest(outputStream, e);
        }
      } else {
        System.out.println("路径不合法");
        continue;
      }

      socket.close();
    }

  }

  private static void sendBadRequest(OutputStream outputStream, BadRequestException e)
      throws IOException {
    outputStream.write("HTTP/1.1 400 Bad request\n".getBytes());
    byte[] msgBytes = e.getMessage().getBytes();
    outputStream.write("Content-Type: text/plain; charset=UTF-8\n".getBytes());
    outputStream.write(("Content-Length: " + msgBytes.length).getBytes());
    outputStream.write("\n\n".getBytes());
    outputStream.write(msgBytes);
  }

  private static void processData(OutputStream outputStream, Request request) throws IOException {
    String url = request.getUrl();

    validateAuth(url, request);

    switch (url) {
      case "/server/user/login": {
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
          request.getSession().put("user", loginUser);
          // 登录成功， 跳转到bill_list.html 页面
          setRedirect(outputStream, request, "/user_list.html");
        }
      }
      break;
      case "/server/user/list": {
        System.out.println("查询用户列表");
        System.out.println(request.getJsonData());
        List<User> userList;
        if (request.getJsonData() != null) {
          User user = JSONObject.parseObject(request.getJsonData(), User.class);
          userList = userService.getUserList(user);
        } else {
          userList = userService.getUserList();
        }

        sendJsonResponse(outputStream, userList, request);
      }
      break;
      case "/server/user/modify": {
        System.out.println("新增或修改用户");
        Map<String, String> formData = request.getFormData();
        System.out.println(formData);
        // 将Map序列化为JSON字符串，然后将json反序列化为User对象
        String s = JSONObject.toJSONString(formData);
        User user = JSONObject.parseObject(s, User.class);
        // TODO 校验用户名是否已经存在，用户密码和确认密码是否相同

        if (user.getId() == 0) {
          userService.addUser(user);
        } else {
          userService.updateUser(user);
        }
        // 操作成功后，重定向到用户列表页面
        setRedirect(outputStream, request, "/user_list.html");
      }
      break;
      case "/server/user/delete": {
        System.out.println("删除用户");
        User user = JSONObject.parseObject(request.getData(), User.class);
        userService.deleteUser(user.getId());
        sendOk(outputStream, request);
      }
      break;
      case "/server/user/get": {
        System.out.println("根据ID查询用户数据");
        User user = JSONObject.parseObject(request.getData(), User.class);
        User rlt = userService.getUser(user.getId());
        sendJsonResponse(outputStream, rlt, request);
      }
      break;
      case "/server/user/getInfo": {
        Object loginUser = request.getSession().get("user");
        sendJsonResponse(outputStream, loginUser, request);
      }
      break;
      // outputStream.write("Set-Cookie: abc=123\n".getBytes());
      case "/server/user/quit":
        // 将服务器缓存的session清除
        MbmSession session = request.getSession();
        SessionUtil.invalidateSession(session);
        // 通知浏览器 cookie中的sessionId失效
        session.invalidate();
        sendOk(outputStream, request);
    }
  }

  /**
   * 如果用户未登录，则抛出异常
   *
   * @param url
   * @param request
   */
  private static void validateAuth(String url, Request request) {
    // 过滤白名单，出现在这里的url，不需要进行权限判断
    List<String> whiteList = new ArrayList<>();
    whiteList.add("/server/user/login");
    if (whiteList.contains(url)) {
      return;
    }

    Object user = request.getSession().get("user");
    if (user == null) {
      // 用户未登录
      throw new BadRequestException("用户未登录");
    }
  }

  private static void sendJsonResponse(OutputStream outputStream, Object object, Request request)
      throws IOException {
    String msg = JSONObject.toJSONString(object);

    outputStream.write("HTTP/1.1 200 OK\n".getBytes());
    outputStream.write("Content-Type: application/json; charset=utf-8\n".getBytes());
    outputStream.write(("Content-Length: " + msg.getBytes().length).getBytes());
    outputStream.write("\n".getBytes());
    writeCookie(outputStream, request);
    outputStream.write("\n".getBytes());
    outputStream.write(msg.getBytes());
  }

  private static void sendOk(OutputStream outputStream, Request request)
      throws IOException {
    outputStream.write("HTTP/1.1 200 OK\n".getBytes());
    writeCookie(outputStream, request);
    outputStream.write("\n".getBytes());
  }

  private static void writeCookie(OutputStream outputStream, Request request) throws IOException {
    MbmSession session = request.getSession();
    if (session.isValid()) {
      // 生效
      outputStream
          .write(("Set-Cookie: SESSIONID=" + session.getSessionId() + "").getBytes());
    } else {
      // 失效
      // Max-Age 通知浏览器，cookied的有效时间， 秒为单位
      outputStream
          .write(("Set-Cookie: SESSIONID=" + session.getSessionId() + "; Max-Age=0").getBytes());
    }

    outputStream.write(("\n").getBytes());
  }

  private static void setRedirect(OutputStream outputStream, Request request, String s)
      throws IOException {
    outputStream.write("HTTP/1.1 302 Found\n".getBytes());
    outputStream
        .write(("Location: " + "http://" + request.getHost() + s).getBytes());
    outputStream.write("\n".getBytes());
  }

  private static void writeStaticResource(OutputStream outputStream, String resourcePath,
      Request request)
      throws IOException {
    BufferedInputStream bufferedInputStream = new BufferedInputStream(
        HttpServerJson.class.getResourceAsStream(resourcePath));
    int available = bufferedInputStream.available();

    outputStream.write("HTTP/1.1 200 OK\n".getBytes());
    // 只有html文件需要增加这句话
    if (resourcePath.endsWith(".html")) {
      outputStream.write("Content-Type: text/html; charset=utf-8\n".getBytes());
    }
    outputStream.write(("Content-Length: " + available + "\n").getBytes());
    writeCookie(outputStream, request);
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
