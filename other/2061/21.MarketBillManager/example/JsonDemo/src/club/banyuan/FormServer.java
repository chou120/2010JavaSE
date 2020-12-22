package club.banyuan;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class FormServer {

  public static void main(String[] args) throws IOException {
    ServerSocket serverSocket = new ServerSocket(5000);

    Socket socket = serverSocket.accept();

    InputStream inputStream = socket.getInputStream();
    BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

    String line = reader.readLine();
    int contentLength = 0;
    while (line != null && line.length() > 0) {
      System.out.println(line);
      if (line.contains("Content-Length: ")) {
        contentLength = Integer.parseInt(line.replaceAll("Content-Length: ", ""));
      }
      line = reader.readLine();

    }

    char[] chars = new char[contentLength];

    reader.read(chars);

    String formData = new String(chars);
    System.out.println(formData);

    StringTokenizer tokenizer = new StringTokenizer(formData, "=|&");
    Map<String, String> map = new HashMap<>();
    while (tokenizer.hasMoreTokens()) {
      map.put(tokenizer.nextToken(), tokenizer.nextToken());
    }

    System.out.println(map);

    // 处理结果
    // 302 重定向
    // 返回html页面
    // 返回数据

  }
}
