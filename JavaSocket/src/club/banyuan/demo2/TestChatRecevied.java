package club.banyuan.demo2;

import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * @author sanye
 * @version 1.0
 * @date 2020/12/9 7:55 下午
 */
public class TestChatRecevied {

  public static void main(String[] args) throws SocketException {
    DatagramSocket receSocket=new DatagramSocket(10006);//接收端服务
    new Thread(new Rece(receSocket)).start();//

  }
}
