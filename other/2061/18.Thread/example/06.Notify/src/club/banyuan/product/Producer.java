package club.banyuan.product;

import java.util.Queue;

public class Producer extends Thread {

  public static int MAX = 100;

  Queue<String> store;
  private int num = 0;

  public Producer(Queue<String> store) {
    this.store = store;
  }

  public Producer(String name, Queue<String> store) {
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
      synchronized (store) {
        if (store.size() == 100) {
          System.out.println("库存满了，停止生产!");
          // continue;
          try {
            store.wait();
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
        }
        System.out.println(getName() + "开始生产");
        store.offer(getName() + ":" + num);
        System.out.println("库存:" + store.size());
        store.notifyAll();
      }
      num++;
    }

  }
}
