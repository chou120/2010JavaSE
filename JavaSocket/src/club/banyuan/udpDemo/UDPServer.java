package club.banyuan.udpDemo;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * @author sanye
 * @version 1.0
 * @date 2020/12/10 1:40 下午
 */
public class UDPServer {

  public static void main(String[] args) {
    DatagramSocket datagramSocket = null;
    while (true) {
      try {
        datagramSocket = new DatagramSocket(9909);
        byte[] bytes = new byte[1024];
        DatagramPacket datagramPacket = new DatagramPacket(bytes, bytes.length);
        //获取到的发送过来数据的长度
        datagramSocket.receive(datagramPacket);

        int length = datagramPacket.getLength();  //接受的字符床数据的长度
        System.out.println(datagramPacket.getAddress() + "发送的数据为:" + new String(bytes, 0, length));

      } catch (IOException e) {
        e.printStackTrace();
      }finally {
        datagramSocket.close();
      }
    }
  }

}
