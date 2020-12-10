package club.banyuan.tcpDemo;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author sanye
 * @version 1.0
 * @date 2020/12/10 3:41 下午
 */
public class ServerDemo {

  public static void main(String[] args) throws IOException {

    ServerSocket serverSocket = new ServerSocket(8989);
    Socket socket = serverSocket.accept(); //返回套接字对象
    //读取客户端发送过来的数据
    InputStream inputStream = socket.getInputStream();
    byte[] bytes = inputStream.readAllBytes();
    String s = new String(bytes);
    System.out.println("客户端发送的数据为:" + s);

    serverSocket.close();

  }
}
