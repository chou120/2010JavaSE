package club.banyuan.explain;

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
