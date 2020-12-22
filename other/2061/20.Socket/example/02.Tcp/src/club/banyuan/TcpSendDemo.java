package club.banyuan;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class TcpSendDemo {

  public static void main(String[] args) throws IOException, InterruptedException {
    // 向指定ip地址和端口号的程序，发起建立tcp连接的请求，如果没有抛出异常，则表示tcp连接被建立
    Socket socket = new Socket("127.0.0.1", 5000);

    OutputStream outputStream = socket.getOutputStream();
    String msg = "你好\n";
    outputStream.write(msg.getBytes());

    System.out.println("保持联系");
    Thread.sleep(1000000);
    // 停掉tcp的连接
    socket.close();


  }
}
