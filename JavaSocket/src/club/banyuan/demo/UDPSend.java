package club.banyuan.demo;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

/**
 * @author sanye
 * @version 1.0
 * @date 2020/12/9 7:33 下午
 */
public class UDPSend {

  public static void main(String[] args) throws IOException {
    System.out.println("发送端启动……");
//        创建UDP传输的发送端
//        思路：
//        1 建立udp的socket服务，因为接收数据 要明确端口号
//        2 将要发送的数据封装到数据包中
//        3 通过udp的socket服务将数据包
//        4 关闭socket服务

    //1 updatesocket服务 使用DatagramSocket对象
    DatagramSocket ds = new DatagramSocket();
    Scanner  scanner=new Scanner(System.in);
    while (true){
      //2 将要发送的数据封装到数据包中
      System.out.println("请输入数据:");
      String str = scanner.nextLine();
      if(str.equals("byte")){
        break;
      }
      //使用DatagramPacket将数据封装到该对象包中
      byte[] buf = str.getBytes();
      DatagramPacket dp =
          new DatagramPacket(buf,buf.length, InetAddress.getByName("localhost"),8888);
      //3 通过udp的socket服务将数据包发送出去，使用send方法
      ds.send(dp);

    }
    //4 关闭资源
    ds.close();
  }
}
