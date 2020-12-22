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

public class JsonServer {

  public static void main(String[] args) throws IOException {
    ServerSocket serverSocket = new ServerSocket(5000);
    while (true) {
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

      OutputStream outputStream = socket.getOutputStream();
      PrintStream printStream = new PrintStream(outputStream);
      printStream.println("HTTP/1.1 200 OK");
      printStream.println();
      // printStream.println("{}");
      // printStream.println("HTTP/1.1 302 Found");
      // printStream.println("Location: http://www.baidu.com");
      printStream.close();
      socket.close();
    }
  }
}
