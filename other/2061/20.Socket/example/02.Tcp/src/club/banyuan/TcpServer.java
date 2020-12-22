package club.banyuan;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpServer {

  public static void main(String[] args) throws IOException {
    ServerSocket serverSocket = new ServerSocket(5000);
    while (true) {
      Socket accept = serverSocket.accept();
      InputStream inputStream = accept.getInputStream();
      byte[] bytes = inputStream.readAllBytes();
      System.out.println(accept.getInetAddress().getHostAddress() + ":" + new String(bytes));
      accept.close();
    }
  }
}
