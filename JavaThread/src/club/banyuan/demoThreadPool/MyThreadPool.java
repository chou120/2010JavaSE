package club.banyuan.demoThreadPool;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author sanye
 * @version 1.0
 * @date 2020/12/8 10:49 上午
 */
public class MyThreadPool {


  public static void main(String[] args) {
    /**
     * 1.创建一个可缓存的线程池。如果线程池的大小超过了处理任务所需要的线程，那么就会回收部分空闲（60秒不执行任务）的线程<br>
     * 2.当任务数增加时，此线程池又可以智能的添加新线程来处理任务<br>
     * 3.此线程池不会对线程池大小做限制，线程池大小完全依赖于操作系统（或者说JVM）能够创建的最大线程大小<br>
     *
     */

//    ExecutorService executorService = Executors.newCachedThreadPool();
//    for (int i = 0; i <10; i++) {
//      int num = i;
//      executorService.submit(() -> System.out.println(Thread.currentThread().getName()+"执行"+ num));
//    }
//    executorService.shutdown();
//
//    System.out.println();

//    for (int i = 0; i <20; i++) {
//      int num = i;
//      executorService.submit(() -> System.out.println(Thread.currentThread().getName()+"执行"+ num));
//
//    }



//    ExecutorService pool = Executors.newSingleThreadExecutor();
//    for (int i = 0; i < 10; i++) {
//      final int ii = i;
//      pool.execute(() -> System.out.println(Thread.currentThread().getName() + "=>" + ii));
//    }
//    pool.shutdown();



    ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(5);
    Runnable r1 = () -> System.out.println("线程名称：" + Thread.currentThread().getName() + "，执行:3秒后执行");
    Runnable r2 = () -> System.out.println("线程名称：" + Thread.currentThread().getName() + "，执行:2秒后执行");

    scheduledThreadPool.schedule(r1, 3, TimeUnit.SECONDS);
    scheduledThreadPool.schedule(r2, 2, TimeUnit.SECONDS);

    scheduledThreadPool.shutdown();

    //使用线程池的方式,发送10万条数据,线程池中只有6个线程,但是要发送给十个人  1 999   1000 1999  2000 2999

  }
}
