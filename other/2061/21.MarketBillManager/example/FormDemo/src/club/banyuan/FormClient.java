package club.banyuan;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class FormClient {

  public static void main(String[] args) throws IOException {
    String url = "http://127.0.0.1:5000/form";
    Map<String, String> map = new HashMap<>();
    map.put("username", "张三");
    map.put("password", "123456");

    String ip = url.split(":")[1].replaceAll("/", "");
    int port = Integer.parseInt(url.split(":")[2].replaceAll("/form", ""));
    String host = url.replaceAll("/form", "").replaceAll("http://", "");
    Socket socket = new Socket(ip, port);

    String data = "";
    for (Entry<String, String> entry : map.entrySet()) {
      data += entry.getKey() + "=" + entry.getValue();
      data += "&";
    }

    System.out.println(data);
    data = data.substring(0, data.length() - 1);

    // 先写头数据
    OutputStream outputStream = socket.getOutputStream();
    PrintStream printStream = new PrintStream(outputStream);
    printStream.println("POST /form HTTP/1.1");
    printStream.println("Content-Length: " + data.toCharArray().length);
    printStream.println("Host: " + host);
    printStream.println();
    printStream.println(data);

    InputStream inputStream = socket.getInputStream();
    BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
    String s = reader.readLine();
    System.out.println(s);
  }
}
