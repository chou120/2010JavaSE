package club.banyuan.demo2;

import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * @author sanye
 * @version 1.0
 * @date 2020/12/9 7:53 下午
 */
public class TestChat {

  public static void main(String[] args) throws SocketException {
    DatagramSocket sendSocket=new DatagramSocket();//发送端服务
    new Thread(new Send(sendSocket)).start();//创建thread类 开启多线程

  }
}
