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
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class CookieClient {

  public static final String COOKIE_PATH = "/Users/liyi/works/repos/banyuan/javase-2061/21.MarketBillManager/example/CookieDemo/cookie";

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
    // 从文件中读取之前的cookie记录
    Map<String, String> storeCookie = JSONObject
        .parseObject(fileInputStream, StandardCharsets.UTF_8,
            new TypeReference<Map<String, String>>() {
            });
    System.out.println(storeCookie);

    // 将Cookie的记录，转换为 Cookie: key=value; key1=value1 的格式
    StringBuilder cookieStr = new StringBuilder();
    for (Entry<String, String> entry : storeCookie.entrySet()) {
      cookieStr.append(entry.getKey()).append("=").append(entry.getValue());
      cookieStr.append("; ");
    }
    if (cookieStr.length() > 0) {
      cookieStr.delete(cookieStr.lastIndexOf(";"), cookieStr.length());
    }

    // 先写头数据
    OutputStream outputStream = socket.getOutputStream();
    PrintStream printStream = new PrintStream(outputStream);
    printStream.println("POST /form HTTP/1.1");
    printStream.println("Host: " + host);
    // 如果之前保存的cookie不为空，则将Cookie的字符串写入到请求头中
    if (cookieStr.length() > 0) {
      printStream.println("Cookie: " + cookieStr.toString());
    }
    printStream.println();

    InputStream inputStream = socket.getInputStream();
    BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
    String s = reader.readLine();
    Map<String, String> cookie = new HashMap<>();
    // 读取并解析服务器返回的数据
    while (s != null && s.length() != 0) {
      System.out.println(s);
      if (s.startsWith("Set-Cookie: ")) {
        // 解析服务器设置的cookie数据，保存到map中
        String[] split = s.replaceAll("Set-Cookie: ", "").split("=");
        cookie.put(split[0], split[1]);
      }
      s = reader.readLine();
    }
    // 将map写入到文件
    FileOutputStream fileOutputStream = new FileOutputStream(
        COOKIE_PATH);
    fileOutputStream.write(JSONObject.toJSONString(cookie).getBytes());
  }
}
