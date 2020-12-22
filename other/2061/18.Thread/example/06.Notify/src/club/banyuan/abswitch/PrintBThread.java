package club.banyuan.abswitch;

public class PrintBThread extends Thread {

  @Override
  public void run() {
    synchronized (Main.class) {
      for (int i = 0; i < 10; i++) {

        try {
          Main.class.wait();
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
        System.out.println("B");
        Main.class.notify();
      }
    }
  }
}
