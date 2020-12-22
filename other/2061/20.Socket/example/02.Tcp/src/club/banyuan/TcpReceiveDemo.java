package club.banyuan;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpReceiveDemo {

  public static void main(String[] args) throws IOException {
    ServerSocket serverSocket = new ServerSocket(5000);
    System.out.println("服务器启动");
    Socket accept = serverSocket.accept();
    System.out.println("目标计算机端口号：" + accept.getPort());
    System.out.println("目标计算机IP：" + accept.getInetAddress().getHostAddress());
    InputStream inputStream = accept.getInputStream();

    byte[] bytes = inputStream.readAllBytes();
    System.out.println(new String(bytes));

    accept.close();
    serverSocket.close();

  }
}
