package club.banyuan.demo2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * @author sanye
 * @version 1.0
 * @date 2020/12/9 7:51 下午
 */
public class Send implements Runnable {

  private DatagramSocket ds;//私有化成员

  public Send(DatagramSocket ds) {
    this.ds = ds;
  }

  public void run() {//重写run方法
    try {//发送端，读键盘，封装在一个单独线程当中
      BufferedReader bufr = new BufferedReader(new InputStreamReader(System.in));//转化流
      String line = null;
      while ((line = bufr.readLine()) != null) {
        if ("886".equals(line)) {
          break;
        }
        byte[] buf = line.getBytes();//建立缓冲区
        DatagramPacket dp = new DatagramPacket(buf, buf.length,
            InetAddress.getByName("localhost"), 10006);//发送到哪去，获取主机的信息
        ds.send(dp);//将包投递出去
      }
    } catch (Exception e) {
      throw new RuntimeException("发送失败");
    }
  }
}
