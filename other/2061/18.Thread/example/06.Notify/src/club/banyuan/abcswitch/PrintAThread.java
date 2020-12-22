package club.banyuan.abcswitch;

import java.util.Random;

public class PrintAThread extends Thread {

  @Override
  public void run() {
    try {
      Thread.sleep(50);
      synchronized (ThreadState.class) {
        for (int i = 0; i < 10; i++) {
          while (ThreadState.turn != Turn.A) {
            ThreadState.class.wait(1000);
          }
          System.out.printf("A");
          Thread.sleep(new Random().nextInt(1000));
          ThreadState.turn = Turn.B;
          ThreadState.class.notifyAll();
        }
      }
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}
