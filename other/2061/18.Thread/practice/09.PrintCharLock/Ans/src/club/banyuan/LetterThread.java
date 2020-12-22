package club.banyuan;

public class LetterThread extends Thread {

  @Override
  public void run() {

    char aChar = 'A';
    try {
      // synchronized (Main.LOCK) {
      NumThread.LOCK.lock();
      while (aChar <= 'Z') {
        NumThread.CON.await();
        System.out.printf("%s ", aChar);
        Thread.sleep(500);
        aChar++;
        NumThread.CON.signal();
        // Main.LOCK.notify();
      }
      // }
    } catch (InterruptedException e) {
      e.printStackTrace();
    } finally {
      NumThread.LOCK.unlock();
    }

  }
}
