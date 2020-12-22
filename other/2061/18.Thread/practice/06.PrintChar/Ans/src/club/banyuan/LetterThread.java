package club.banyuan;

public class LetterThread extends Thread {

  @Override
  public void run() {

    char aChar = 'A';
    try {
      synchronized (Main.LOCK) {
        while (aChar <= 'Z') {
          Main.LOCK.wait();
          System.out.printf("%s ", aChar);
          Thread.sleep(500);
          aChar++;
          Main.LOCK.notify();
        }
      }
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

  }
}
