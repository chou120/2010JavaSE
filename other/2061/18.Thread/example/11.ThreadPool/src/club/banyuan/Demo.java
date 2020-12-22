package club.banyuan;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor.AbortPolicy;
import java.util.concurrent.ThreadPoolExecutor.CallerRunsPolicy;
import java.util.concurrent.ThreadPoolExecutor.DiscardOldestPolicy;
import java.util.concurrent.ThreadPoolExecutor.DiscardPolicy;
import java.util.concurrent.TimeUnit;

public class Demo {

  public static void main(String[] args) {
    // while (true) {
    // int corePoolSize,
    // int maximumPoolSize,
    // long keepAliveTime,
    // TimeUnit unit,
    // BlockingQueue<Runnable> workQueue,
    // RejectedExecutionHandler handler

    // 当线程池内部激活线程数量小于corePoolSize，如果有任务提交进来，开启新的线程执行任务
    // 如果核心线程数量全部被任务占用，将新任务放到 阻塞队列中。
    // 如果阻塞队列满了，如果maximumPoolSize 大于corePoolSize，则会开启新的线程执行任务
    // 如果正在执行任务达到maximumPoolSize数量，并且阻塞队列满了，根据拒绝策略进行处理。
    // keepAliveTime 如果空闲的线程数量大于核心线程数，间隔该时间后，关闭空闲的线程。

    //
    ArrayBlockingQueue<Runnable> workQueue = new ArrayBlockingQueue<>(2);
    ThreadPoolExecutor executor = new ThreadPoolExecutor(1, 2, 10, TimeUnit.SECONDS,
        workQueue,
        new DiscardOldestPolicy());

    // 新任务，无法执行的时候，抛出异常
    // AbortPolicy

    // 阻塞提交任务的线程，直到满足执行条件
    // CallerRunsPolicy

    // 丢弃不能执行的线程
    // DiscardPolicy

    // 丢弃队列中最早加入的任务
    // DiscardOldestPolicy

    for (int i = 0; i < 10; i++) {
      executor.execute(new DemoThread());
      System.out.println(workQueue);
    }

    // 关闭线程池，线程需要在执行完队列中的任务后退出
    // executor.shutdown();

    // 发送中断给正在执行的任务，阻塞队列中的任务将不再执行
    executor.shutdownNow();

    Executors.newFixedThreadPool(10);
    Executors.newSingleThreadExecutor();
    Executors.newCachedThreadPool();

    // ExecutorService executorService = Executors.newFixedThreadPool(10);

    // Thread thread = new Thread(new Runnable() {
    //   @Override
    //   public void run() {
    //     System.out.println(1);
    //     try {
    //       Thread.sleep(100000);
    //     } catch (InterruptedException e) {
    //       e.printStackTrace();
    //     }
    //   }
    // });
    // executorService.submit(thread);

    // }
  }
}
