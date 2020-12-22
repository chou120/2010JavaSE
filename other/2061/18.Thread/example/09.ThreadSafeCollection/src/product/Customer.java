package product;

import java.util.concurrent.BlockingQueue;

public class Customer extends Thread {

  BlockingQueue<String> store;

  public Customer(BlockingQueue<String> store) {
    this.store = store;
  }

  public Customer(String name, BlockingQueue<String> store) {
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

      try {
        String poll = store.take();
        synchronized (store) {
          System.out.println(getName() + "消费：" + poll);
          System.out.println("库存:" + store.size());
        }
      } catch (InterruptedException e) {
        e.printStackTrace();
      }

    }

  }
}
