package product;

import java.util.Queue;
import java.util.concurrent.BlockingQueue;

public class Producer extends Thread {

  public static int MAX = 100;

  BlockingQueue<String> store;
  private int num = 0;

  public Producer(BlockingQueue<String> store) {
    this.store = store;
  }

  public Producer(String name, BlockingQueue<String> store) {
    super(name);
    this.store = store;
  }

  @Override
  public void run() {
    while (true) {
      try {
        Thread.sleep(300);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }

      System.out.println(getName() + "准备生产");

      try {
        store.put(getName() + ":" + num++);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }

      synchronized (store) {
        System.out.println(getName() + "生产了一个产品");
        System.out.println("库存:" + store.size());
      }
    }
  }


}
