package club.banyuan.thread;

import java.util.Scanner;

public class ScanThread extends Thread {

  // 开启一个线程，接收键盘的输入，将输入的值，逐个字符依次输出到屏幕上，输出每个字符的时间间隔是500ms
  @Override
  public void run() {
    Scanner sca = new Scanner(System.in);
    System.out.println("请输入...");
    String str=sca.next();
    int  x=0;
    while (x<str.length()){
      System.out.print(str.charAt(x)); //截取每一个字符
      x++;
      try {
      Thread.sleep(500);
      }catch (InterruptedException e){
          e.printStackTrace();
      }
    }
  }

  public static void main(String[] args) {
    ScanThread scanThread = new ScanThread();
    scanThread.start();
  }
}
