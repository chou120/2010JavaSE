package club.banyuan.product;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * synchronized 缺点
 * 1. 获取不到锁，会一直等待
 * 2. 通知的时候，会把所有基于相同锁对象的线程同时唤醒
 * <p>
 * synchronized 优先
 * 1. 锁的获取和释放不需要程序控制
 */
public class Main {

  public static void main(String[] args) {
    Queue<String> queue = new LinkedList<>();
    for (int i = 0; i < 3; i++) {
      new Customer("消费者" + (i + 1), queue).start();
    }

    for (int i = 0; i < 4; i++) {
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
