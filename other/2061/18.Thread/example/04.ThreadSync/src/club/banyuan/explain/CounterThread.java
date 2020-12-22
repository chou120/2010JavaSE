package club.banyuan.explain;

public class CounterThread extends Thread {

  private Counter counter;

  public CounterThread(Counter counter) {
    this.counter = counter;
  }

  @Override
  public void run() {
    for (int i = 0; i < 10; i++) {
      synchronized (counter) {
        System.out.println(counter);
      }
    }

  }
}
