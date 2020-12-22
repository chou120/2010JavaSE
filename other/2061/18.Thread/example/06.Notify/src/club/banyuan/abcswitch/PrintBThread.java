package club.banyuan.abcswitch;

import java.util.Random;

public class PrintBThread extends Thread {

  @Override
  public void run() {
    synchronized (ThreadState.class) {
      for (int i = 0; i < 10; i++) {
        try {
          while (ThreadState.turn != Turn.B) {
            ThreadState.class.wait(1000);
          }
          System.out.printf("B");
          Thread.sleep(new Random().nextInt(1000));
          ThreadState.turn = Turn.C;
          ThreadState.class.notifyAll();
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
    }
  }
}
