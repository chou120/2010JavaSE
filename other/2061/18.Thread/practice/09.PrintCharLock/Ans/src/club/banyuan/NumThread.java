package club.banyuan;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class NumThread extends Thread {
  public static Lock LOCK = new ReentrantLock();
  public static Condition CON = LOCK.newCondition();

  @Override
  public void run() {
    int num = 1;
    try {
      Thread.sleep(100);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    try {
      // 晚一点执行，让打印letter的线程先进入到wait状态
      LOCK.lock();
      // synchronized (Main.LOCK) {
      while (num <= 52) {
          System.out.printf("%d %d ", num, num + 1);
          num += 2;
          Thread.sleep(500);
          CON.signal();
          CON.await();
          //  Main.LOCK.notify();
          //  Main.LOCK.wait();
          //}
      }
    } catch (InterruptedException e) {
      e.printStackTrace();
    }finally {
      LOCK.unlock();
    }
  }
}
