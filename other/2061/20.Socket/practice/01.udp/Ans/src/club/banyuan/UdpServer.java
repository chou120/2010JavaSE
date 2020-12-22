package club.banyuan;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.Scanner;

public class UdpServer {

  public static void main(String[] args) throws SocketException {

    Scanner scanner = new Scanner(System.in);
    DatagramSocket socket = new DatagramSocket(5000);
    byte[] msgBuf = new byte[1024];
    while (true) {
      System.out.println("准备接收消息");
      DatagramPacket packet = new DatagramPacket(msgBuf, msgBuf.length);
      try {
        socket.receive(packet);
        // 因为receive会阻塞，因此无法在接收键盘输入quit后立即退出
        String s = scanner.nextLine();
        if ("quit".equalsIgnoreCase(s)) {
          System.out.println("程序退出！");
          return;
        }
        byte[] data = packet.getData();
        int length = packet.getLength();
        String msg = new String(data, 0, length);
        System.out.println("来自" + packet.getAddress().getHostAddress() + "的消息:" + msg);
      } catch (IOException e) {
        System.out.println(e.getMessage());
      }
    }
  }
}
