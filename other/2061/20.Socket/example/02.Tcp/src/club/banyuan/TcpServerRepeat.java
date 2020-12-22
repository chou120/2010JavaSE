package club.banyuan;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpServerRepeat {

  public static void main(String[] args) throws IOException {
    ServerSocket serverSocket = new ServerSocket(5000);
    while (true) {
      Socket accept = serverSocket.accept();
      InputStream inputStream = accept.getInputStream();
      OutputStream outputStream = accept.getOutputStream();
      BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outputStream));
      BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
      String line = reader.readLine();
      while (line != null) {
        System.out.println(accept.getInetAddress().getHostAddress() + ":" + line);
        writer.write(line + " received");
        writer.newLine();
        writer.flush();
        line = reader.readLine();
      }
      accept.close();
    }
  }
}
