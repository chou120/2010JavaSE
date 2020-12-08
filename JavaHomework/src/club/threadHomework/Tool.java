package club.threadHomework;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author sanye
 * @version 1.0
 * @date 2020/12/8 9:05 上午
 */
public class Tool {

  public  static  final Lock lock=new ReentrantLock();
  public  static  final Condition  condition=lock.newCondition();
  public  static  boolean flag=false;

  /**
   *
   * condition对象通过lock.newCondition()来创建，
   * 用condition.await（）来实现让线程等待，是线程进入阻塞。
   * 用condition.signal()来实现唤醒线程。唤醒的线程是用同一个conditon对象调用await()方法而进入阻塞。
   * 并且和wait/notify一样，await（）和signal（）也是在同步代码区内执行。
   *
   *
   *  首先我们需要明白condition对象是依赖于lock对象的，
   *  意思就是说condition对象需要通过lock对象进行创建出来(调用Lock对象的newCondition()方法)。
   *  consition的使用方式非常的简单。但是需要注意在调用方法前获取锁。
   *
   *
   *    condition可以通俗的理解为条件队列。当一个线程在调用了await方法以后，
   *    直到线程等待的某个条件为真的时候才会被唤醒。这种方式为线程提供了更加简单的等待/通知模式。
   *    Condition必须要配合锁一起使用，因为对共享状态变量的访问发生在多线程环境下。
   *    一个Condition的实例必须与一个Lock绑定，因此Condition一般都是作为Lock的内部实现。
   *
   * await() ：造成当前线程在接到信号或被中断之前一直处于等待状态。
   *
   * await(long time, TimeUnit unit) ：造成当前线程在接到信号、被中断或到达指定等待时间之前一直处于等待状态。
   *
   * awaitNanos(long nanosTimeout) ：造成当前线程在接到信号、被中断或到达指定等待时间之前一直处于等待状态。
   * 返回值表示剩余时间，如果在nanosTimesout之前唤醒，那么返回值 = nanosTimeout - 消耗时间，如果返回值 <= 0 ,则可以认定它已经超时了。
   *
   * awaitUninterruptibly() ：造成当前线程在接到信号之前一直处于等待状态。【注意：该方法对中断不敏感】。
   *
   * awaitUntil(Date deadline) ：造成当前线程在接到信号、被中断或到达指定最后期限之前一直处于等待状态。
   *  如果没有到指定时间就被通知，则返回true，否则表示到了指定时间，返回返回false。
   *
   * signal() ：唤醒一个等待线程。该线程从等待方法返回前必须获得与Condition相关的锁。
   *
   * signal()All ：唤醒所有等待线程。能够从等待方法返回的线程必须获得与Condition相关的锁。
   *
   */



}
