package product.refine;

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

      synchronized (store) {
        String poll = null;
        while ((poll = store.poll()) == null) {
          try {
            store.wait();
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
        }
        System.out.println(getName() + "消费：" + poll);
        System.out.println("库存:" + store.size());
        store.notifyAll();
      }

    }

  }
}
