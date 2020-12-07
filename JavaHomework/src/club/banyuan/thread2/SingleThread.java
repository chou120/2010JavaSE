package club.banyuan.thread2;

public class SingleThread {

  public static void main(String[] args) {
    Counter counter = new Counter();
    for (int i = 0; i < 1000; i++) {
      counter.num++;
    }

    System.out.println(counter);
  }

}
