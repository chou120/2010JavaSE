package club.banyuan.product;

import java.util.Queue;
import java.util.concurrent.locks.Lock;

public class Customer extends Thread {

  private Queue<String> store;
  private Lock lock;

  public Customer(Queue<String> store) {
    this.store = store;
  }

  public Customer(String name, Queue<String> store) {
    super(name);
    this.store = store;
  }

  public Customer(String name, Queue<String> store, Lock lock) {
    super(name);
    this.store = store;
    this.lock = lock;
  }

  @Override
  public void run() {
    while (true) {
      try {
        Thread.sleep(1000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      // synchronized (store) {
      ProductLock.lock.lock();
      if (!store.isEmpty()) {
        String poll = store.poll();
        System.out.println(getName() + "消费：" + poll);
        System.out.println("库存:" + store.size());
      } else {
        System.out.println("产品为空");
        // 通知工厂生产
        System.out.println("通知工厂生产");
        ProductLock.productCondition.signalAll();
        try {
          ProductLock.consumerCondition.await();
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
      ProductLock.lock.unlock();
    }
  }
}
