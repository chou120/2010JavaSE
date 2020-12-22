package club.banyuan;

import cn.hutool.core.lang.TypeReference;
import com.alibaba.fastjson.JSONObject;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 * cookie通常是和域名绑定，每个域名都有独立的存储区域存储对应的cookie
 */
public class CookieClientRefine {

  public static final String COOKIE_PATH = "/Users/liyi/works/repos/banyuan/javase-2061/21.MarketBillManager/example/CookieDemo/cookierefine";

  public static void main(String[] args) throws Exception {
    String url = "http://127.0.0.1:5000/form";

    String ip = url.split(":")[1].replaceAll("/", "");
    int port = Integer.parseInt(url.split(":")[2].replaceAll("/form", ""));
    String host = url.replaceAll("/form", "").replaceAll("http://", "");
    Socket socket = new Socket(ip, port);

    FileInputStream fileInputStream = new FileInputStream(COOKIE_PATH);
    //
    // Map<String, String> storeCookie = JSONObject
    //     .parseObject(fileInputStream, StandardCharsets.UTF_8,
    //         new TypeReference<Map<String, String>>() {
    //         });
    // key 是域名，域名下面value又是map，用来存储对应的cookie的多个键值对
    Map<String, Map<String, String>> storeCookie = JSONObject
        .parseObject(fileInputStream, StandardCharsets.UTF_8,
            new TypeReference<Map<String, Map<String,String>>>() {
            });
    System.out.println(storeCookie);
    if(storeCookie == null){
      storeCookie = new HashMap<>();
    }

    StringBuilder cookieStr = new StringBuilder();
    Map<String, String> hostMap = storeCookie.get(host);
    if (hostMap != null) {
      for (Entry<String, String> entry : hostMap.entrySet()) {
        cookieStr.append(entry.getKey()).append("=").append(entry.getValue());
        cookieStr.append("; ");
      }
      if (cookieStr.length() > 0) {
        cookieStr.delete(cookieStr.lastIndexOf(";"), cookieStr.length());
      }
    }

    // 先写头数据
    OutputStream outputStream = socket.getOutputStream();
    PrintStream printStream = new PrintStream(outputStream);
    printStream.println("POST /form HTTP/1.1");
    printStream.println("Host: " + host);
    if (cookieStr.length() > 0) {
      printStream.println("Cookie: " + cookieStr.toString());
    }
    printStream.println();

    InputStream inputStream = socket.getInputStream();
    BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
    String s = reader.readLine();

    // 从服务器返回的数据，不需要重新创建新的map，防止其他域名的cookie数据被覆盖
    Map<String, String> cookie = storeCookie.getOrDefault(host, new HashMap<>());
    // 这里为了防止 新创建的map和host的关联关系没有保存到 storeCookie中
    storeCookie.put(host,cookie);
    while (s != null && s.length() != 0) {
      System.out.println(s);
      if (s.startsWith("Set-Cookie: ")) {
        String[] split = s.replaceAll("Set-Cookie: ", "").split("=");
        cookie.put(split[0], split[1]);
      }
      s = reader.readLine();
    }
    FileOutputStream fileOutputStream = new FileOutputStream(
        COOKIE_PATH);
    fileOutputStream.write(JSONObject.toJSONString(storeCookie).getBytes());
  }
}
