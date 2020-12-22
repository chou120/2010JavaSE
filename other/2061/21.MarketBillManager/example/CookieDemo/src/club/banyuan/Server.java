package club.banyuan;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Server {

  public static void main(String[] args) throws Exception {
    ServerSocket serverSocket = new ServerSocket(5000);

    while (true) {
      System.out.println("等待接入");
      Socket socket = serverSocket.accept();
      InputStream inputStream = socket.getInputStream();
      BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

      // 保存客户端发送的cookie键值对
      Map<String, String> cookie = new HashMap<>();
      String line = reader.readLine();
      // 解析 Cookie: key=value; key1=value1;
      // 将key value 和 key1 value1 通过分组的方式提取出来
      Pattern pattern = Pattern.compile("([\\w-]*)=([\\w-]*);?");
      while (line != null && line.length() > 0) {
        System.out.println(line);
        if (line.startsWith("Cookie: ")) {
          // 获取头部信息中的Cookie字符串
          Matcher matcher = pattern.matcher(line);
          while (matcher.find()) {
            // 提取分组中的内容，1组为key，2组为value
            cookie.put(matcher.group(1), matcher.group(2));
          }
        }
        line = reader.readLine();
      }

      System.out.println(cookie);
      String sessionId = null;
      // 如果cookie中包含了 SESSIONID字段，表示之前请求过该服务器
      if (cookie.containsKey("SESSIONID")) {
        System.out.println("有这个SESSIONID:" + cookie.get("SESSIONID"));
      } else {
        // 如果cookie中没有包含，则分配一个sessionId，表示后续的请求将会带有该sessionid
        sessionId = UUID.randomUUID().toString();
        System.out.println("分配了一个新的ID：" + sessionId);
      }

      OutputStream outputStream = socket.getOutputStream();
      PrintStream printStream = new PrintStream(outputStream);
      printStream.println("HTTP/1.1 200 OK");
      // 服务器端通过设置 Set-Cookie 请求头通知客户端，用cookie保存后续的数据
      // 数据为key value的键值对，如果有多条数据，发送多条 Set-Cookie的 头部信息，每个一行
      if (sessionId != null) {
        // 写入sessionId的信息到cookie中
        printStream.println("Set-Cookie: SESSIONID=" + sessionId);
      }
      printStream.println();
      // printStream.println("HTTP/1.1 302 Found");
      // printStream.println("Location: http://www.baidu.com");

      socket.close();
    }

  }
}
