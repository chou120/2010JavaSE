package product;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Main {

  public static void main(String[] args) {
    BlockingQueue<String> queue = new ArrayBlockingQueue<>(Producer.MAX);
    for (int i = 0; i < 3; i++) {
      new Customer("消费者" + (i + 1), queue).start();
    }

    for (int i = 0; i < 3; i++) {
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
