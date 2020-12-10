package club.banyuan.udpThreadDemo;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * @author sanye
 * @version 1.0
 * @date 2020/12/10 2:41 下午
 */
public class Recevied implements Runnable {


  private DatagramSocket datagramSocket = null;

  public Recevied(DatagramSocket datagramSocket) {
    this.datagramSocket = datagramSocket;
  }

  @Override
  public void run() {
    System.out.println("等待连接中.....");
    try {
      while (true) {

        byte[] bytes = new byte[1024];
        DatagramPacket datagramPacket = new DatagramPacket(bytes, bytes.length);
        //获取到的发送过来数据的长度

          datagramSocket.receive(datagramPacket);

          int length = datagramPacket.getLength();  //接受的字符床数据的长度
          System.out
              .println(datagramPacket.getAddress() + "发送的数据为:" + new String(bytes, 0, length));
        }

    } catch (IOException e) {
      e.printStackTrace();
    }
  }

}
