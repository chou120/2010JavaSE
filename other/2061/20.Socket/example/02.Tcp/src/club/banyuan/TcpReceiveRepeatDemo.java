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

public class TcpReceiveRepeatDemo {

  public static void main(String[] args) throws IOException {
    ServerSocket serverSocket = new ServerSocket(5000);
    System.out.println("服务器启动");
    Socket accept = serverSocket.accept();
    System.out.println("目标计算机端口号：" + accept.getPort());
    System.out.println("目标计算机IP：" + accept.getInetAddress().getHostAddress());
    InputStream inputStream = accept.getInputStream();
    OutputStream outputStream = accept.getOutputStream();
    BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
    BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outputStream));
    String line = reader.readLine();
    while (line != null) {
      System.out.println(line);
      writer.write("message received");
      writer.newLine();
      writer.flush();
      line = reader.readLine();
    }

    // 如果连接保持，readAllBytes 无法结束，必须等到对方close 连接，才会返回
    // byte[] bytes = inputStream.readAllBytes();
    // System.out.println(new String(bytes));

    accept.close();
    serverSocket.close();

  }
}
