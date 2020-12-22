package club.banyuan.product;

import java.util.Queue;

public class Customer extends Thread {

  Queue<String> store;

  public Customer(Queue<String> store) {
    this.store = store;
  }

  public Customer(String name, Queue<String> store) {
    super(name);
    this.store = store;
  }

  @Override
  public void run() {
    while (true) {
      try {
        Thread.sleep(1000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      synchronized (store) {
        if (!store.isEmpty()) {
          String poll = store.poll();
          System.out.println(getName() + "消费：" + poll);
          System.out.println("库存:" + store.size());
        } else {
          System.out.println("产品为空");
          // 通知工厂生产
          System.out.println("通知工厂生产");
          store.notifyAll();
          try {
            store.wait();
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
        }
      }
    }

  }
}
