package club.banyuan.demo;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * @author sanye
 * @version 1.0
 * @date 2020/12/9 7:37 下午
 */
public class UDPReceive {
  public static void main(String[] args) throws IOException {
    System.out.println("接收端启动……");
//           建立UDP接收端的思路
//           1.建立UDP socket服务
//           2.创建数据包，用于存储接受到的数据，方便用户数据包的方法解析这些数据
//           3.使用socket服务的receive方法将接收的数据存储到数据包中
//           4.通过数据包的方法解析数据包中的数据
//           5.关闭资源

    //1 建立UDP socket服务
     DatagramSocket ds = new DatagramSocket(8888);
   while(true){
     //2 建立数据包
     byte[] buf = new byte[1024];
     DatagramPacket dp = new DatagramPacket(buf,buf.length);
     //3 使用接收方法将数据存储到数据包中
     ds.receive(dp);
     //4 通过数据包的方法解析数据包中的数据 解析其中的数据，比如，地址、端口、数据内容
     String ip = dp.getAddress().getHostAddress();
     int port = dp.getPort();
     String text= new String(dp.getData(),0,dp.getLength());
     dp.getData();
     System.out.println(ip+":"+port+":"+text);
     if(text.equals("bye")){
       break;
     }

   }
    //5 关闭资源
    ds.close();
  }

}
