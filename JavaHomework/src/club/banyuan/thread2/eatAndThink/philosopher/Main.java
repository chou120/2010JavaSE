package club.banyuan.thread2.eatAndThink.philosopher;

import java.util.ArrayList;
import java.util.List;

public class Main {

  public static void main(String[] args) {
    List<Philosopher> philosophers = new ArrayList<>();
    List<Chopstick> chopsticks = new ArrayList<>();

    for (int i = 0; i < 5; i++) {
      chopsticks.add(new Chopstick(i + 1 + ""));
    }

    for (int i = 0; i < 5; i++) {
      Philosopher one = new Philosopher("哲学家" + (i + 1), chopsticks.get(i),
          chopsticks.get((i + 1) % 5));
      philosophers
          .add(one);
      one.start();
    }
  }
}
