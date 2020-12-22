package club.banyuan;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class UdpServer {

  public static void main(String[] args) throws IOException {
    DatagramSocket socket = new DatagramSocket(5000);
    // 创建一个byte数组，用来保存接收到的数据包的数据
    byte[] buf = new byte[1024];
    // 创建 DatagramPacket 用来接收 发送的数据
    DatagramPacket datagramPacket = new DatagramPacket(buf, buf.length);

    while (true) {
      // receive方法将会阻塞，直到收到数据，收到的数据将保存在 datagramPacket 对象中
      // 该对象中还会保存发送数据的计算机的信息
      socket.receive(datagramPacket);
      // System.out.println("接收完成");
      // 接收到的数据
      byte[] data = datagramPacket.getData();
      // 接收到的数据的真实长度
      int length = datagramPacket.getLength();
      // 来自数据发送端的地址信息
      InetAddress address = datagramPacket.getAddress();
      // 获取数据发送端的ip地址
      // System.out.println(address.getHostAddress());
      // System.out.println(datagramPacket.getPort());

      System.out
          .println("接收到来自：" + address.getHostAddress() + "的消息(" + new String(data, 0, length) + ")");
    }
  }
}
