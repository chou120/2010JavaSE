package club.banyuan.threadpool.vsthis;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class Demo extends Thread {

  public Demo(String name) {
    super(name);
  }

  @Override
  public void run() {
    try {
      Thread.sleep(1000);
    } catch (InterruptedException e) {
      Thread.currentThread().interrupt();
      System.out.println(this.getName());
      System.out.println(Thread.currentThread().getName());
      System.out.println(this == Thread.currentThread());
      System.out.println(this.isInterrupted());
      System.out.println(Thread.currentThread().isInterrupted());
    }
    // this 指代的是调用run方法的对象
    // Thread.currentThread 返回的是正在执行的线程对象，线程对象未必是run方法的调用对象

  }

  public static void main(String[] args) throws InterruptedException {

    Demo demo = new Demo("1");
    // demo.start();
    // demo.interrupt();

    ExecutorService executorService = Executors.newSingleThreadExecutor();
    executorService.execute(demo);
    // 无法中断，因为不是以demo的线程启动的
    // demo.interrupt();
    executorService.shutdownNow();
  }
}
