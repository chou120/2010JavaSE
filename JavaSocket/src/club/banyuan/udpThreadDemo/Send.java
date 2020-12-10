package club.banyuan.udpThreadDemo;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Scanner;

/**
 * @author sanye
 * @version 1.0
 * @date 2020/12/10 2:41 下午
 */
public class Send implements Runnable {

  private DatagramSocket datagramSocket = null;

  public Send(DatagramSocket datagramSocket) {
    this.datagramSocket = datagramSocket;
  }

  @Override
  public void run() {
    System.out.println("客户端正在连接中...");
    try {
    Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("请输入数据:");
            String str = scanner.nextLine();
            byte[] bytes = str.getBytes();
            datagramSocket = new DatagramSocket();
            //传递的是字节穿度
            DatagramPacket datagramPacket = new DatagramPacket(bytes, bytes.length,
                InetAddress.getByName("192.168.11.31"), 9001);
            datagramSocket.send(datagramPacket);
        }

      } catch (UnknownHostException | SocketException e) {
        e.printStackTrace();
      } catch (IOException e) {
        e.printStackTrace();
      }
  }
}
