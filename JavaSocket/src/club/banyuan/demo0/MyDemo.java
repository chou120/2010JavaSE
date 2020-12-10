package club.banyuan.demo0;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author sanye
 * @version 1.0
 * @date 2020/12/10 11:13 上午
 */
public class MyDemo {

  public static void main(String[] args) throws UnknownHostException {
    InetAddress localHost = InetAddress.getLocalHost();
    System.out.println(localHost.getHostName() + "---" + localHost.getHostAddress() + "---");

    InetAddress byName = InetAddress.getByName("www-pre.banyuan.club");
    //   47.103.65.236
    System.out.println(byName.getHostName()+"...."+byName.getHostAddress());

    //端口号




  }
}
