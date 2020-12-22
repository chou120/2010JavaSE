package club.banyuan;

import java.util.ArrayList;
import java.util.List;

public class SharedCounter {

  static int counter = 0;


  public static void reset() {
    counter = 0;
  }

  public static int increment(int numThreads, int numIncrementsPerThread)
      throws InterruptedException {

    List<Thread> rlt = new ArrayList<>();
    for (int i = 0; i < numThreads; i++) {
      Thread one = new Thread(() -> {
        synchronized (SharedCounter.class) {
          counter += numIncrementsPerThread;
        }
      });
      one.start();
      rlt.add(one);
    }
    rlt.forEach(t -> {
      try {
        t.join();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    });
    return counter;
  }
}
