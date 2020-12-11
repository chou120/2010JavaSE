package club.banyuan.test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
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

    BufferedReader  socketReader=new BufferedReader(new InputStreamReader(socket.getInputStream()));

    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    for (int i = 0; i < 10; i++) {
      System.out.println("请输入第"+(i+1)+"个消息:");
      String s = reader.readLine();
      writer.write("这是第"+(i+1)+"条数据:"+s);
      writer.flush();

      socket.shutdownOutput();//告诉服务器端客户端接下来没有输入这个操作了

      String s1 = socketReader.readLine();
      if(s1!=null){
        System.out.println("服务端的消息为:"+s1);
      }
    }
    // 停掉tcp的连接
    socket.close();
  }
}
