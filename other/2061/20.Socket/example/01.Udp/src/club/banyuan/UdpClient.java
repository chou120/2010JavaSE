package club.banyuan;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class UdpClient {

  public static void main(String[] args) throws IOException, InterruptedException {
    DatagramSocket socket = new DatagramSocket();
    int count = 1;
    while (true) {
      String msg = "广播" + count + "次";
      count++;
      byte[] bytes = msg.getBytes();
      DatagramPacket datagramPacket = new DatagramPacket(bytes, 0, bytes.length,
          InetAddress.getByName("192.168.11.255"), 9999);
      System.out.println("发送消息：" + msg);
      socket.send(datagramPacket);
      Thread.sleep(10000);
    }

    // socket.close();
  }
}
