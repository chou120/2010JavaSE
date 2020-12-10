package club.banyuan.tcpDemo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author sanye
 * @version 1.0
 * @date 2020/12/10 3:43 下午
 */
public class Client {

  public static void main(String[] args) throws IOException {
    Socket socket = new Socket("127.0.0.1", 8989);

    OutputStream outputStream = socket.getOutputStream();  //套接字里面本身自带的一个转换流  专门用来处理套接字里面的 数据问题
    BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outputStream));

    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    for (int i = 0; i < 10; i++) {
      System.out.println("请输入第"+(i+1)+"个消息:");
      String s = reader.readLine();
      writer.write("这是第"+(i+1)+"条数据:"+s);
      writer.newLine();
      writer.flush();

    }
    // 停掉tcp的连接
    socket.close();

  }
}
