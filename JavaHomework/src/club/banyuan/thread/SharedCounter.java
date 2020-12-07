package club.banyuan.thread;

import java.util.ArrayList;
import java.util.List;

public class SharedCounter {

  static int counter = 0;

  //这个方法应该启动numThreads数量的线程，并且每个线程都应该向counter中增加numIncrementsPerThread的值。
  public static void reset() {
    counter = 0;
  }

  public static int increment(int numThreads, int numIncrementsPerThread)
      throws InterruptedException {

    List<Thread> arrayList = new ArrayList<>();
    for (int i = 0; i < numThreads; i++) { //10
      Thread thread = new Thread(new Runnable() {
        @Override
        public void run() {
          synchronized (SharedCounter.class){
            try {
              Thread.sleep(100);
            } catch (InterruptedException e) {
              e.printStackTrace();
            }
            counter+=numIncrementsPerThread;
          }
        }
      });
      thread.start();
      arrayList.add(thread);
    }
    arrayList.forEach((t)-> {
      try {
        t.join();  //迭代的时候让后面线程在等待
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    });
    return counter;
  }
}
class Test{

  public static void main(String[] args) {
    try {
      final int increment = SharedCounter.increment(10, 5);
      Thread.sleep(100);
      System.out.println(">>>>>"+increment);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}