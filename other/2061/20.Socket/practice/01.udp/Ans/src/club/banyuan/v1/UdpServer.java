package club.banyuan.v1;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class UdpServer {

  public static void main(String[] args) throws SocketException {
    DatagramSocket socket = new DatagramSocket(5000);
    byte[] msgBuf = new byte[1024];
    while (true) {
      System.out.println("准备接收消息");
      DatagramPacket packet = new DatagramPacket(msgBuf, msgBuf.length);
      try {
        socket.receive(packet);
        byte[] data = packet.getData();
        int length = packet.getLength();
        String msg = new String(data, 0, length);
        if ("quit".equalsIgnoreCase(msg)) {
          System.out.println("程序退出");
          return;
        } else {
          System.out.println("来自" + packet.getAddress().getHostAddress() + "的消息:" + msg);
        }
      } catch (IOException e) {
        System.out.println(e.getMessage());
      }
    }
  }
}
