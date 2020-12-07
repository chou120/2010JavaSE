package club.banyuan.thread2.print;

import java.util.List;

public class PrintThread extends Thread {

  private List<String> stringList;

  public PrintThread(List<String> stringList) {
    this.stringList = stringList;
  }

  @Override
  public void run() {
    synchronized (PrintString.class) {
      for (String s : stringList) {
        System.out.print(s);
        System.out.print(" ");
        try {
          Thread.sleep(500);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
    }
    System.out.println();
  }
}
