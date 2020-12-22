package club.banyuan;

public class NumThread extends Thread {

  @Override
  public void run() {
    int num = 1;
    try {
      // 晚一点执行，让打印letter的线程先进入到wait状态
      Thread.sleep(100);
      synchronized (Main.LOCK) {
      while (num <= 52) {
          System.out.printf("%d %d ", num, num + 1);
          num += 2;
          Thread.sleep(500);
          Main.LOCK.notify();
          Main.LOCK.wait();
        }
      }
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}
