package club.banyuan.http;

import club.banyuan.entity.User;
import club.banyuan.request.Request;
import club.banyuan.service.UserService;
import club.banyuan.util.PropUtil;
import com.alibaba.fastjson.JSONObject;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

/**
 * @author sanye
 * @version 1.0
 * @date 2020/12/11 9:52 上午
 */
public class HttpServer {

  private static UserService userService = new UserService();

  public static void main(String[] args)  {
    try (ServerSocket serverSocket = new ServerSocket(9000)) {
      System.out.println("服务器已经启动...");

      while (true) {
        try (Socket socket = serverSocket.accept()) {
          InputStream inputStream = socket.getInputStream();
          //用来向前端页面输出数据的
          final OutputStream outputStream = socket.getOutputStream();

          Request request = Request.parse(inputStream);
          String url = request.getUrl();

          if (url.startsWith("/server")) {
            //如果是以server开始的 就需要处理数据
            //处理数据的时候需要分发处理,不仅仅只有一个请求
            dispatchRequest(request, outputStream);

          } else {
            SendStaticFile(outputStream, request);
          }
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
    } catch (IOException e) {
      e.printStackTrace();
    }

  }

  private static void dispatchRequest(Request request, OutputStream outputStream)
      throws IOException {
    String url = request.getUrl();
    switch (url) {
      case "/server/user/login":
        String data = request.getData();
        System.out.println("-----------------------------------请求数据为:"+data);
        User user = JSONObject.parseObject(data, User.class);
        User login = userService.login(user);
        if(login!=null){
          //登录成功
          DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
          dataOutputStream.writeBytes("HTTP/1.1 200 OK\n");
          dataOutputStream.writeBytes("\n");
          dataOutputStream.flush();
        }else {
          //登录失败
          DataOutputStream dataOutputStream = new DataOutputStream(outputStream);

          //异常信息是json格式 所以需要创建map对象
          Map<String,Object> map=new HashMap<>();
          map.put("data", "数据错误");

          final byte[] bytes = JSONObject.toJSONString(map).getBytes();

          dataOutputStream.writeBytes("HTTP/1.1 400 bad_Request\n");
          dataOutputStream.writeBytes("Content-Length: " + bytes.length + "\n");
          dataOutputStream.writeBytes("Content-Type: application/json; charset=utf-8\n");

          dataOutputStream.writeBytes("\n");
          dataOutputStream.write(bytes);

          dataOutputStream.flush();
        }

        break;
      default:
        break;
    }


  }
  //去加载静态资源文件
  private static void SendStaticFile(OutputStream outputStream, Request request) throws IOException {

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
