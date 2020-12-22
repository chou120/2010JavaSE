package club.banyuan.abcswitch;

import java.util.Random;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class PrintAThread extends Thread {

  private Lock lock;
  private Condition wait;
  private Condition notify;

  public PrintAThread(Lock lock, Condition wait, Condition notify) {
    this.lock = lock;
    this.wait = wait;
    this.notify = notify;
  }

  @Override
  public void run() {
    try {
      Thread.sleep(50);
      lock.lock();
      for (int i = 0; i < 10; i++) {
        System.out.printf("A");
        Thread.sleep(new Random().nextInt(1000));
        notify.signal();
        wait.await();
      }
    } catch (InterruptedException e) {
      e.printStackTrace();
    } finally {
      lock.unlock();
    }
  }
}
