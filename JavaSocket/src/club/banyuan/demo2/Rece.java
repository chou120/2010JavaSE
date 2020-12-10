package club.banyuan.demo2;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * @author sanye
 * @version 1.0
 * @date 2020/12/9 7:52 下午
 */
public class Rece implements Runnable {

  private DatagramSocket ds;

  public Rece(DatagramSocket ds) {
    this.ds = ds;
  }

  public void run() {
    try {
      while (true) {//循环接受
        byte[] buf = new byte[1024];//创建缓存区
        DatagramPacket dp = new DatagramPacket(buf, buf.length);//数据包接受数据
        ds.receive(dp);//将接受的数据存储到定义好的数据包中
        String ip = dp.getAddress().getHostAddress();//获取发送端主机地址和主机信息
        String data = new String(dp.getData(), 0, dp.getLength());

        System.out.println(ip + ":" + data);//
      }
    } catch (Exception e) {
      throw new RuntimeException("接收端失败");
    }
  }
}
