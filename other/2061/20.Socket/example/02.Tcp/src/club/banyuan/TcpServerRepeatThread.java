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

public class TcpServerRepeatThread extends Thread {

  private Socket accept;

  public TcpServerRepeatThread(Socket accept) {
    this.accept = accept;
  }

  @Override
  public void run() {
    try {
      InputStream inputStream = accept.getInputStream();
      OutputStream outputStream = accept.getOutputStream();
      BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outputStream));
      BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
      String line = reader.readLine();
      while (line != null) {
        System.out.println(accept.getInetAddress().getHostAddress() + ":" + line);
        writer.write(line + " received");
        writer.newLine();
        writer.flush();
        line = reader.readLine();
      }
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      try {
        accept.close();
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }

  public static void main(String[] args) throws IOException {
    ServerSocket serverSocket = new ServerSocket(5000);
    while (true) {
      // 为了解决处理多个任务的情况，需要让主线程始终都保持执行这里的代码
      Socket accept = serverSocket.accept();
      System.out.println(accept.getInetAddress().getHostAddress() + "接入！");
      // 开启一个线程
      Thread thread = new TcpServerRepeatThread(accept);
      thread.start();
    }
  }
}
