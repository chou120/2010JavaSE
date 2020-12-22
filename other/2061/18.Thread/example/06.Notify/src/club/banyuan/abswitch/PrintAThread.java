package club.banyuan.abswitch;

public class PrintAThread extends Thread {

  @Override
  public void run() {
    try {
      Thread.sleep(50);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    synchronized (Main.class) {
      for (int i = 0; i < 10; i++) {

        System.out.println("A");
        Main.class.notify();
        try {
          Main.class.wait();
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
    }
  }
}
