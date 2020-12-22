package club.banyuan.v1;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Scanner;

public class UdpClient {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    while (true) {
      System.out.println("请输入  IP 端口 消息:");
      String input = scanner.nextLine();
      if (invalid(input)) {
        System.out.println("输入不合法");
        continue;
      }
      boolean isQuit = false;
      String ip;
      int port;
      String msg;

      if ("quit".equalsIgnoreCase(input)) {
        ip = "127.0.0.1";
        port = 5000;
        msg = "quit";
        isQuit = true;
      } else {
        String[] msgArr = input.split(" ");
        ip = msgArr[0];
        port = Integer.parseInt(msgArr[1]);
        msg = msgArr[2];
      }

      try {
        DatagramPacket datagramPacket = new DatagramPacket(msg.getBytes(), msg.getBytes().length,
            InetAddress.getByName(ip), port);
        DatagramSocket datagramSocket = new DatagramSocket();
        datagramSocket.send(datagramPacket);
        if (isQuit) {
          break;
        }
      } catch (UnknownHostException e) {
        System.out.println("ip地址不合法");
      } catch (IOException e) {
        System.out.println("发送失败");
      } catch (Exception e) {
        System.out.println(e.getMessage());
      }
    }
  }

  /**
   * 对输入是否为quit，输入长度是否合法进行校验
   *
   * @param input
   * @return false 输入合法， true 输入不合法
   */
  private static boolean invalid(String input) {
    // QUIT  Quit  qUIT  都认为是合法的
    if ("quit".equalsIgnoreCase(input)) {
      return false;
    }

    // 如果输入中间包含了多个空格，会导致拆分字符串后的数组长度变大，其中会包含空字符的数组元素
    // 优化方案 split("\\s+") 正则表达式的方案
    String[] msgArr = input.split(" ");
    return msgArr.length != 3;
  }
}
