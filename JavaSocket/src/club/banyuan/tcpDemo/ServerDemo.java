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
 * @date 2020/12/10 3:41 下午
 */
public class ServerDemo {

  public static void main(String[] args) throws IOException {

    ServerSocket serverSocket = new ServerSocket(8989);

    System.out.println("服务器启动");
    Socket accept = serverSocket.accept();
    System.out.println("目标计算机端口号：" + accept.getPort());
    System.out.println("目标计算机IP：" + accept.getInetAddress().getHostAddress());

    InputStream inputStream = accept.getInputStream();  //读取

    //转换流的方式
    BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

    String line = reader.readLine();

    while (line != null) {
      System.out.println("new----->"+line);
      line = reader.readLine();
    }

    // 如果连接保持，readAllBytes 无法结束，必须等到对方close 连接，才会返回
    // byte[] bytes = inputStream.readAllBytes();
    // System.out.println(new String(bytes));

    accept.close();
    serverSocket.close();
  }
}
