package club.banyuan.mbm;

import club.banyuan.mbm.util.MbmSession;
import club.banyuan.mbm.util.SessionUtil;
import java.io.BufferedReader;
import java.io.IOException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Request {

  private String url;
  private int contentLength;
  private String data;
  private String host;
  private MbmSession session;
  private Map<String, String> cookie = new HashMap<>();

  // 根据实际需要，取数据的时候，根据form格式的数据解析
  public Map<String, String> getFormData() {
    Map<String, String> rlt = new HashMap<>();
    // 为了处理 key=&key1= 空值的情况
    String[] pairs = data.split("&");
    for (String pair : pairs) {
      String[] entry = pair.split("=");
      if (entry.length > 1) {
        rlt.put(entry[0], entry[1]);
      } else if (entry.length == 1) {
        rlt.put(entry[0], "");
      }
    }
    return rlt;
  }

  public String getJsonData() {
    return data;
  }

  public static Request parse(BufferedReader reader) throws IOException {
    Request request = new Request();
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
      } else if (line.startsWith("Cookie: ")) {
        // 处理cookie信息，获取保存用户登录状态的id
        processSession(request, line);
      }
      line = reader.readLine();
    }

    // 如果session 为null，说明之前没有包含信息，生成一个session
    if (request.getSession() == null) {
      MbmSession session = new MbmSession();
      request.setSession(session);
      SessionUtil.setSession(session);
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
      request.setData(reqData);
    } else {
      // 处理get请求url尾部带有数据的情况
      if (url.contains("?")) {
        String[] split = url.split("\\?");
        // ？前面的内容放到url里，后面的内容当做数据
        request.setUrl(split[0]);
        request.setData(split[1]);
      }
    }

    return request;
  }

  private static void processSession(Request request, String line) {
    String[] split = line.replaceAll("Cookie: ", "").split(";");
    for (String s : split) {
      String[] keyValue = s.trim().split("=");
      request.getCookie().put(keyValue[0], keyValue[1]);
    }

    if (request.getCookie().containsKey("SESSIONID")) {
      String sessionId = request.getCookie().get("SESSIONID");
      MbmSession session = SessionUtil.getSession(sessionId);
      request.setSession(session);
    }
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

  public MbmSession getSession() {
    return session;
  }

  public void setSession(MbmSession session) {
    this.session = session;
  }

  public Map<String, String> getCookie() {
    return cookie;
  }

  public void setCookie(Map<String, String> cookie) {
    this.cookie = cookie;
  }
}
