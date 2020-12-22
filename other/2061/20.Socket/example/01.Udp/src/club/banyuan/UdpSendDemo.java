package club.banyuan;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import jdk.jfr.DataAmount;

public class UdpSendDemo {

  // 0~1024
  public static void main(String[] args) throws IOException {
    DatagramSocket socket = new DatagramSocket(3000);
    String msg = "你好";
    byte[] bytes = msg.getBytes();
    DatagramPacket datagramPacket = new DatagramPacket(bytes, 0, bytes.length,
        InetAddress.getByName("127.0.0.1"), 5000);

    socket.send(datagramPacket);
    socket.close();

  }
}
