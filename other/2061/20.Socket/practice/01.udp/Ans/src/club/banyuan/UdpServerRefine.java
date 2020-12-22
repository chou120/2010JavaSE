package club.banyuan;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.ServerSocket;
import java.net.SocketException;
import java.util.Scanner;

public class UdpServerRefine extends Thread {

  //  volatile 表示另一个线程修改此变量的值能够立即被其他线程感知到变化，并且立即使用变化之后的值
  private volatile static boolean isRunning = true;

  private DatagramSocket socket;

  public UdpServerRefine(DatagramSocket socket) {
    this.socket = socket;
  }

  @Override
  public void run() {

    Scanner scanner = new Scanner(System.in);
    while (true) {
      String s = scanner.nextLine();
      if ("quit".equalsIgnoreCase(s)) {
        // 修改主线程中用来判断程序是否执行的标志
        isRunning = false;
        // 关闭socket，将主线程中receive方法退出阻塞
        socket.close();
        // 需要告知主线程，程序退出了
        return;
      }
    }
  }

  public static void main(String[] args) throws SocketException {

    DatagramSocket socket = new DatagramSocket(5000);

    UdpServerRefine receiveMsgThread = new UdpServerRefine(socket);
    receiveMsgThread.start();
    byte[] msgBuf = new byte[1024];
    while (isRunning) {
      System.out.println("准备接收消息");
      DatagramPacket packet = new DatagramPacket(msgBuf, msgBuf.length);
      try {
        socket.receive(packet);
        byte[] data = packet.getData();
        int length = packet.getLength();
        String msg = new String(data, 0, length);
        System.out.println("来自" + packet.getAddress().getHostAddress() + "的消息:" + msg);
      } catch (IOException e) {
        // 有多种情况都会进入到处理该异常的代码
        // 只有在socket关闭后，才会退出，因此这里不进行退出的控制，而是有isRunning变量标识是否退出
        System.out.println(e.getMessage());
      }
    }
    System.out.println("程序退出");
  }
}
