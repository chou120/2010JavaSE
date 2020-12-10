package club.banyuan.udpThreadDemo;

import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * @author sanye
 * @version 1.0
 * @date 2020/12/10 2:53 下午
 */
public class TestSend {


  public static void main(String[] args) throws SocketException {
     DatagramSocket datagramSocket = new DatagramSocket();
     new  Thread(new Send(datagramSocket)).start();
  }
}
