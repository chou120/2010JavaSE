package club.banyuan;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class SharedCounter {
  static int counter = 0;


  public static void reset() {
    counter = 0;
  }

  public static int increment(int numThreads, int numIncrementsPerThread) throws InterruptedException {
    return counter;
  }
}
