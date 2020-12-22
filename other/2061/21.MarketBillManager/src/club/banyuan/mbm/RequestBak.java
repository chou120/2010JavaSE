package club.banyuan.mbm;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class RequestBak {

  // TODO 增加一个method，如果是GET，如果url后面有数据，将数据解析到FormData的Map中
  private String url;
  private int contentLength;
  private String data;
  private String host;
  private Map<String, String> formData = new HashMap<>();

  public Map<String, String> getFormData() {
    return formData;
  }

  public void setFormData(Map<String, String> formData) {
    this.formData = formData;
  }

  public static RequestBak parse(BufferedReader reader) throws IOException {
    RequestBak request = new RequestBak();
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
      return null;
    }

    request.setUrl(url);

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
      } else if (line.startsWith("Host: ")) {
        String host = line.replaceAll("Host: ", "");
        request.setHost(host);
      }
      line = reader.readLine();
    }

    request.setContentLength(contentLength);

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

      // key=value&key1=value1 格式的字符串转换为
      // key:value   key1: value1 的map内容
      StringTokenizer tokenizer = new StringTokenizer(reqData, "=|&");
      while (tokenizer.hasMoreTokens()) {
        request.getFormData().put(tokenizer.nextToken(), tokenizer.nextToken());
      }
      System.out.println("form data");
      System.out.println(request.getFormData());
    }

    return request;
  }

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
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


  public String getHost() {
    return host;
  }

  public void setHost(String host) {
    this.host = host;
  }
}
