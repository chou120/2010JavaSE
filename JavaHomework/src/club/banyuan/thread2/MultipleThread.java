package club.banyuan.thread2;

import java.util.ArrayList;
import java.util.List;

public class MultipleThread extends Thread {

  private Counter counter;
  private static Object other = new Object();

  public MultipleThread(Counter counter) {
    this.counter = counter;
  }

  @Override
  public void run() {
    try {
      Thread.sleep(1000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    for (int i = 0; i < 200; i++) {
      // 同步代码块  monitor
      // 多个线程操作同一块内存区域的值的时候，对这个值产生了读写

      // counter必须是线程之间的共享对象
      // 引用数据类型的变量
      // synchronized (counter) {
      //   counter.num++;
      // }
      counter.add();
    }
  }

  public static void main(String[] args) throws InterruptedException {
    Counter counter = new Counter();
    List<MultipleThread> threads = new ArrayList<>();
    threads.add(new MultipleThread(counter));
    threads.add(new MultipleThread(counter));
    threads.add(new MultipleThread(counter));
    threads.add(new MultipleThread(counter));
    threads.add(new MultipleThread(counter));
    for (MultipleThread thread : threads) {
      thread.start();
    }

    List<CounterThread> printThreadList = new ArrayList<>();
    printThreadList.add(new CounterThread(counter));
    printThreadList.add(new CounterThread(counter));
    printThreadList.add(new CounterThread(counter));
    printThreadList.add(new CounterThread(counter));
    printThreadList.add(new CounterThread(counter));

    for (MultipleThread thread : threads) {
      thread.join();
    }
    for (CounterThread thread : printThreadList) {
      thread.start();
    }

  }
}
