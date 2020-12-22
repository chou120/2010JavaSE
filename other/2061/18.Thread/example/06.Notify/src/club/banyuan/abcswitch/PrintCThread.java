package club.banyuan.abcswitch;

import java.util.Random;

public class PrintCThread extends Thread {

  @Override
  public void run() {
    synchronized (ThreadState.class) {
      for (int i = 0; i < 10; i++) {
        try {

          while (ThreadState.turn != Turn.C) {
            ThreadState.class.wait(1000);
          }
          System.out.printf("C");
          Thread.sleep(new Random().nextInt(1000));
          ThreadState.turn = Turn.A;
          ThreadState.class.notifyAll();

        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
    }
  }
}
