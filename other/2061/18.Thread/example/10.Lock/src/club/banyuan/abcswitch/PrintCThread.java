package club.banyuan.abcswitch;

import java.util.Random;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class PrintCThread extends Thread {

  private Lock lock;
  private Condition wait;
  private Condition notify;

  public PrintCThread(Lock lock, Condition wait, Condition notify) {
    this.lock = lock;
    this.wait = wait;
    this.notify = notify;
  }

  @Override
  public void run() {
    lock.lock();
    try {
      for (int i = 0; i < 10; i++) {
        wait.await();
        System.out.printf("C");
        Thread.sleep(new Random().nextInt(1000));
        notify.signal();
      }
    } catch (InterruptedException e) {
      e.printStackTrace();
    } finally {
      lock.unlock();
    }
  }
}
