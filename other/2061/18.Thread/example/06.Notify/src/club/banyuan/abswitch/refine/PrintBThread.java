package club.banyuan.abswitch.refine;

public class PrintBThread extends Thread {

  public static boolean isNotify = false;

  @Override
  public void run() {
    synchronized (Main.class) {
      for (int i = 0; i < 10; i++) {

        while (!isNotify) {
          try {
            Main.class.wait(1000);
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
        }
        System.out.printf("B");
        PrintAThread.isNotify = true;
        isNotify = false;
        Main.class.notify();
      }
    }
  }
}
