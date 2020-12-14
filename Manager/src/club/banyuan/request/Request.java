package club.banyuan.request;

/**
 * @author sanye
 * @version 1.0
 * @date 2020/11/3 11:16 上午
 * <p>
 * 在讲用户登录模块的时候使用
 */

import com.alibaba.fastjson.JSONObject;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * 用来封装解析浏览器发送的头信息的数据
 */
public class Request {

  private String url;
  private String host;

  private int contentLength;
  /**
   * 浏览器提交的json数据
   */
  private String data;

  /**
   * 将浏览器发送的inputStream中的数据转换为一个Request对象
   * <p>
   * 主要获取url和data
   * url用来判断那个方法处理这个请求或者下载哪个文件
   * data 对应的业务需要使用的 用户数据
   *
   * @param inputStream
   */
  public static Request parse(InputStream inputStream) {
// socket 获取到的是inputStream，需要将inputStream转换为reader 以便更好的处理数据
    String url = null;
    String host = null;
    try {
      // 将input转换为 reader，为了调用readLine API
      BufferedReader reader = new BufferedReader(
          new InputStreamReader(inputStream));

      // 将浏览器的请求头包含的信息转换为一个Request对象
      Request request = new Request();

      // GET /url HTTP/1.1
      // 第一行请求头数据，包含了请求方式和请求路径，解析请求路径，根据这个路径才能判断返回的资源
      String line = reader.readLine();

     // System.out.println("line----------------------->>>>>" + line);

      url = line.split(" ")[1];
      host = null;
      int contentLength = 0;
      // 后续的请求头中，第二行包含了Host信息
      // 读取空行后，循环退出
      while (line != null && line.length() != 0) {
        if (line.startsWith("Host: ")) {
          host = line.replace("Host: ", "");
        }
        if (line.startsWith("Content-Length: ")) {
          contentLength = Integer.parseInt(line.replace("Content-Length: ", ""));
        }
        System.out.println(line);
        line = reader.readLine();
      }

      // header头部结束后有数据，读取这些数据
      if (contentLength > 0) {
        char[] payload = new char[contentLength];
        int read = reader.read(payload);
        String data = new String(payload, 0, read);
        System.out.println("data:" + data);
        request.setData(data);
      }

      System.out.println("url:" + url);
      System.out.println("host:" + host);
      System.out.println("Content-length:" + contentLength);
      System.out.println("读取头部文件结束");

      request.setContentLength(contentLength);
      request.setUrl(url);
      request.setHost(host);

      // 处理request的session
      //handleSession(request);

      return request;

    } catch (IOException e) {

      e.printStackTrace();
      return null;
    }

  }

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public String getHost() {
    return host;
  }

  public void setHost(String host) {
    this.host = host;
  }

  public int getContentLength() {
    return contentLength;
  }

  public void setContentLength(int contentLength) {
    this.contentLength = contentLength;
  }

  public String getData() {
    return data;
  }

  public void setData(String data) {
    this.data = data;
  }


  public <T> T parseJsonObject(Class<T> cls) {
    return JSONObject.parseObject(data, cls);
  }


}
