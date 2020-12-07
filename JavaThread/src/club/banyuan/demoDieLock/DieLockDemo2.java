package club.banyuan.demoDieLock;

import java.util.concurrent.TimeUnit;

/**
 * @author sanye
 * @version 1.0
 * @date 2020/12/7 1:36 下午
 */
public class DieLockDemo2 implements  Runnable{

  @Override
  public void run() {
    //while (true){
//      synchronized (Tool.OBJECT2){
//        System.out.println(Thread.currentThread().getName()+"进来了,获取到了Obj2锁");  //B
//        try {
//          Thread.sleep(1000);
//        } catch (InterruptedException e) {
//          e.printStackTrace();
//        }
//        synchronized (Tool.OBJECT1){
//          System.out.println(Thread.currentThread().getName()+"进来了,获取到了Obj1锁");
//        }
//      }//到此才会释放锁

    //使用信号量的方式解决死锁问题
    try {
      if (Tool.semaphore2.tryAcquire(2000, TimeUnit.MILLISECONDS)) {  //表示当前线程在规定的时间内有没有获取到令牌
        System.out.println(Thread.currentThread().getName() + "进来了,获取到了第2个锁");
        if (Tool.semaphore1.tryAcquire(4000, TimeUnit.MILLISECONDS)) {  //表示当前线程在规定的时间内有没有获取到令牌
          System.out.println(Thread.currentThread().getName() + "进来了,获取到了第1个锁");
        }
      }
    } catch (InterruptedException e) {
      e.printStackTrace();
    }finally {
      Tool.semaphore2.release();
      Tool.semaphore1.release();
      System.out.println("2222222");
    }
  }
    //}
}
