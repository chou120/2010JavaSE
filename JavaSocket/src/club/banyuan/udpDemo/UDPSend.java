package club.banyuan.udpDemo;

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
 * @date 2020/12/10 1:40 下午
 */
public class UDPSend {

  public static void main(String[] args) {

    DatagramSocket datagramSocket=null;
    Scanner  scanner=new Scanner(System.in);
    while (true) {
      try {
        System.out.println("请输入数据:");
        String str = scanner.nextLine();
        byte[] bytes = str.getBytes();
        datagramSocket = new DatagramSocket();
        //传递的是字节穿度
        DatagramPacket datagramPacket = new DatagramPacket(bytes, bytes.length,
            InetAddress.getLocalHost(), 9909);
        datagramSocket.send(datagramPacket);

         datagramSocket.close();

      } catch (UnknownHostException | SocketException e) {
        e.printStackTrace();
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
    //循环输入   循环接收

  }
}
