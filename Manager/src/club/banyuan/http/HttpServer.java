package club.banyuan.http;

import club.banyuan.entity.User;
import club.banyuan.request.Request;
import club.banyuan.service.UserService;
import club.banyuan.sessionDemo.MySession;
import club.banyuan.util.PropUtil;
import com.alibaba.fastjson.JSONObject;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author sanye
 * @version 1.0
 * @date 2020/11/2 5:04 下午
 * <p>
 * <p>
 * 测试登录使用的Http服务器
 */
public class HttpServer {

  private static UserService userService = new UserService();


  public static void main(String[] args) {
    try (ServerSocket serverSocket = new ServerSocket(9000)) {
      System.out.println("创建服务器");
      while (true) {
        try (Socket socket = serverSocket.accept();) {
          System.out.println("客户端接入");
          Request request = Request.parse(socket.getInputStream());//返回一个Request对象
          String url = request.getUrl();

          final OutputStream outputStream = socket.getOutputStream();
          // 和前台代码匹配的。以/server 路径开头的，表示需要进行数据处理
          if (url.startsWith("/server")) {
            //如果是以server开始的 就需要处理数据
            //处理数据的时候需要分发处理,不仅仅只有一个请求
            dispatchRequest(request, outputStream);

          } else {
            //没有以server 开头，表示请求的是资源，html、css、js、图片等文件，返回文件
            SendStaticFile(outputStream, request);
          }
        } catch (IOException e) {
          // 服务器在处理请求的时候出现了异常
          e.printStackTrace();
          //返回服务器的状态码
        }
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  /**
   * 根据url不同   数据进行分发处理
   *
   * @param request
   * @param outputStream
   */
  private static void dispatchRequest(Request request, OutputStream outputStream)
      throws IOException {
    String url = request.getUrl();

    switch (url) {
      case "/server/user/login":
        String data = request.getData();//前端传递过来的json 数据
        User user = JSONObject.parseObject(data, User.class);
        User login = userService.login(user);
        if (login != null) {
          //登录成功
          sendSuccess(outputStream);

        } else { //否则登录失败

          sendFail(outputStream, "账户或者密码错误");

        }
        break;

      case "/server/user/list":

        DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
        dataOutputStream.writeBytes("HTTP/1.1 200 ok\n");

        Object user4 = MySession.map.get("user");
        if (user4 != null) {
          List<User> userList = userService.load();
          //获取到前端传递过来的数据
          String data1 = request.getData();
          User user1 = JSONObject.parseObject(data1, User.class);  // a  传递过来的name
          List<User> newUserList = null;
          if (!user1.getName().equals("") && user1.getName() != null) {
            //前端有数据传递过来的情况下
            //根据条件进行过滤
            newUserList = userList.stream().filter((users) -> { //""
              if (users.getName().contains(user1.getName())) {
                return true;
              }
              return false;
            }).collect(Collectors.toList());

          } else {
            //也就是说前端没有任何数据传递过来的情况下
            newUserList = userList;
          }
          sendSuccess(outputStream, newUserList);
        }
        break;

      case "/server/user/add":

        //确定前端传递过来的json
        String userData = request.getData();
        User user2 = JSONObject.parseObject(userData, User.class);

        String msg = userService.addUser(user2);
        //如果添加成功
        sendSuccess(outputStream, msg);

        break;

      case "/server/user/delete":
        String data2 = request.getData(); //{"id":4}
        User user3 = JSONObject.parseObject(data2, User.class);

        boolean flag = userService.deleteUserById(user3);
        if (flag) {
          sendSuccess(outputStream, "移除成功");
        } else {
          sendSuccess(outputStream, "移除失败");
        }

        break;

      case "/server/user/get":

        String data3 = request.getData(); //{"id":4}
        User userOne = JSONObject.parseObject(data3, User.class);
        User jsonUser = userService.getById(userOne);
        sendSuccess(outputStream, jsonUser);

        break;

      case "/server/user/update":
        String updateData = request.getData(); //{"id":4}
        User updateUser = JSONObject.parseObject(updateData, User.class);

        userService.updateUserById(updateUser);
        sendSuccess(outputStream, "操作成功");

        break;

      //  登录的时候获取登录用户的信息  2
      case "/server/user/getInfo":
        try {
          //获取用户登录的信息
          User user5 = (User) MySession.map.get("user");
          //
          sendSuccess(outputStream, user5.getName());  //NullPointException

        } catch (Exception e) {
          //如果登录用户为空  就显示空数据
          sendFail(outputStream, "请先登录");
          userService.setList(new ArrayList<>());
        }
        break;

      case "/server/user/quit":  //退出功能  3
        MySession.map.remove("user");
        sendSuccess(outputStream);
        break;
      default:
        // TODO 异常
        break;
    }


  }

  private static void sendSuccess(OutputStream outputStream, Object msg) throws IOException {

    Map<String, Object> map = new HashMap<>();
    map.put("data", msg);

    DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
    byte[] bytes = JSONObject.toJSONString(map).getBytes();

    dataOutputStream.writeBytes("HTTP/1.1 200 OK\n");
    dataOutputStream.writeBytes("Content-Length: " + bytes.length + "\n");
    dataOutputStream.writeBytes("Content-Type: application/json; charset=utf-8\n");
    dataOutputStream.writeBytes("\n");
    dataOutputStream.write(bytes);
    dataOutputStream.flush();


  }


  /**
   * 登录成功
   *
   * @param outputStream
   * @throws IOException
   */

  private static void sendSuccess(OutputStream outputStream) throws IOException {
    DataOutputStream dataOutputStream = new DataOutputStream(outputStream);

    dataOutputStream.writeBytes("HTTP/1.1 200 OK\n");
    dataOutputStream.writeBytes("\n");
    dataOutputStream.flush();
  }

  /**
   * 发送登录请求失败
   *
   * @param outputStream
   * @param msg
   * @throws IOException
   */
  private static void sendFail(OutputStream outputStream, String msg) throws IOException {
    DataOutputStream dataOutputStream = new DataOutputStream(outputStream);

    //异常信息是json格式 所以需要创建map对象
    Map<String, Object> map = new HashMap<>();
    map.put("data", msg);

    final byte[] bytes = JSONObject.toJSONString(map).getBytes();

    dataOutputStream.writeBytes("HTTP/1.1 400 bad_Request\n");
    dataOutputStream.writeBytes("Content-Length: " + bytes.length + "\n");
    dataOutputStream.writeBytes("Content-Type: application/json; charset=utf-8\n");

    dataOutputStream.writeBytes("\n");
    dataOutputStream.write(bytes);

    dataOutputStream.flush();
  }

  /**
   * 用来加载静态资源文件
   *
   * @param outputStream
   * @param request
   * @throws IOException
   */
  private static void SendStaticFile(OutputStream outputStream, Request request)
      throws IOException {
    final String url = request.getUrl();
    File file = new File(PropUtil.getProp("page.root"), url);

    if (!file.isFile()) {  //如果在前端发送的地址栏中没有检测到pages文件夹下文件的存在 就显示404页面
      file = new File(PropUtil.getProp("page.root"), "/404.html");
    }

    try (FileInputStream fileInputStream = new FileInputStream(file)) {
      DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
      // 响应头
      // 字符串 换行
      // 字符串 换行
      // Content-Length: 1234  换行之后的数据长度
      // 。。。。
      // 换行
      // bytes数组
      /**
       * 先发送响应头  一般响应头包含以下: 状态码和字节长度
       */
      dataOutputStream.writeBytes("HTTP/1.1 200 OK\n");
      dataOutputStream.writeBytes("Content-Length: " + fileInputStream.available() + "\n");

      /**
       * 此处的url中包含了html  和css  的一些静态的资源
       *    但是静态资源在前端页面的渲染方式又不一样  所以在这里做个判断
       *
       */
      if (url.endsWith(".html")) {
        dataOutputStream.writeBytes("Content-Type: text/html; charset=utf-8;\n");
      } else if (url.endsWith(".css")) {
        dataOutputStream.writeBytes("Content-Type: text/css; charset=utf-8;\n");
      }

      //使用换行符对响应头和文件数据进行分开  不然文件数据没法显示在页面上
      dataOutputStream.writeBytes("\n");

      dataOutputStream.write(fileInputStream.readAllBytes());

      dataOutputStream.flush();
    }
  }

}


