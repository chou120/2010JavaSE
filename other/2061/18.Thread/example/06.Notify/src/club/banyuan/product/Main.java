package club.banyuan.product;

import java.util.LinkedList;
import java.util.Queue;

public class Main {

  public static void main(String[] args) {
    Queue<String> queue = new LinkedList<>();
    for (int i = 0; i < 10; i++) {
      new Customer("消费者" + (i + 1), queue).start();
    }

    for (int i = 0; i < 15; i++) {
      new Producer("生产者" + (i + 1), queue).start();
    }
    // Customer c1 = new Customer("消费者1", queue);
    // Customer c2 = new Customer("消费者2", queue);
    // Producer producer = new Producer("生产者1", queue);
    // c1.start();
    // c2.start();
    // producer.start();
  }
}
