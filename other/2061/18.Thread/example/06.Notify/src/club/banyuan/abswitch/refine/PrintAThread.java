package club.banyuan.abswitch.refine;

public class PrintAThread extends Thread {

  public static boolean isNotify;

  @Override
  public void run() {
    synchronized (Main.class) {
      for (int i = 0; i < 10; i++) {

        System.out.printf("A");
        PrintBThread.isNotify = true;
        isNotify = false;
        Main.class.notify();
        while (!isNotify) {
          try {
            Main.class.wait(1000);
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
        }

      }
    }
  }
}
