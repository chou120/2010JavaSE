package club.banyuan;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class TcpSendRepeatDemo {

  public static void main(String[] args) throws IOException, InterruptedException {
    // 向指定ip地址和端口号的程序，发起建立tcp连接的请求，如果没有抛出异常，则表示tcp连接被建立
    Socket socket = new Socket("127.0.0.1", 5000);

    OutputStream outputStream = socket.getOutputStream();
    BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outputStream));
    InputStream inputStream = socket.getInputStream();
    BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
    for (int i = 0; i < 10; i++) {
      writer.write("第" + i + "条消息");
      writer.newLine();
      writer.flush();
      String s = reader.readLine();
      System.out.println(s);
    }
    // 停掉tcp的连接
    socket.close();


  }
}
