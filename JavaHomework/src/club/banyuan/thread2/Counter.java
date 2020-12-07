package club.banyuan.thread2;

public class Counter {

  int num = 0;

  @Override
  public String toString() {
    return "Counter{" +
        "num=" + num +
        '}';
  }

  public void add() {
    synchronized (this) {
      num++;
    }
  }
}
