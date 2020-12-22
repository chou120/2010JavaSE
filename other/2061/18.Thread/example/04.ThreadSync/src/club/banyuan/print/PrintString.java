package club.banyuan.print;

import java.util.List;

public class PrintString {

  private List<String> stringList;

  public PrintString(List<String> stringList) {
    this.stringList = stringList;
  }

  public void print() throws InterruptedException {
    // 通过类的对象加锁，保证多线程间使用的是同一个对象的锁
    synchronized (PrintString.class) {
      for (String s : stringList) {
        System.out.print(s);
        System.out.print(" ");
        Thread.sleep(500);
      }
    }
    System.out.println();
  }
}
