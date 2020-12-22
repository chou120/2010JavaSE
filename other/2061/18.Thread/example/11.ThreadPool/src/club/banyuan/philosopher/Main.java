package club.banyuan.philosopher;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

  public static void main(String[] args) {
    List<Philosopher> philosophers = new ArrayList<>();
    List<Chopstick> chopsticks = new ArrayList<>();

    for (int i = 0; i < 5; i++) {
      chopsticks.add(new Chopstick(i + 1 + ""));
    }

    ExecutorService executorService = Executors.newFixedThreadPool(5);

    for (int i = 0; i < 5; i++) {
      Philosopher one = new Philosopher("哲学家" + (i + 1), chopsticks.get(i),
          chopsticks.get((i + 1) % 5));
      philosophers.add(one);
      executorService.execute(one);
    }

    try {
      Thread.sleep(20 * 1000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    executorService.shutdownNow();

    for (Philosopher philosopher : philosophers) {
      philosopher.printResult();
    }
  }
}
