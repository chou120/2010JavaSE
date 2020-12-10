package club.banyuan.tcpDemo;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @author sanye
 * @version 1.0
 * @date 2020/12/10 3:43 下午
 */
public class Client {

  public static void main(String[] args) throws IOException {

    Socket  socket=new Socket("192.168.11.31", 8989);
    OutputStream outputStream = socket.getOutputStream();
    outputStream.write("张三".getBytes());
    socket.close();

  }

}
