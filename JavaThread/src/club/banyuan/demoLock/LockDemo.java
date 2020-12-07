package club.banyuan.demoLock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author sanye
 * @version 1.0
 * @date 2020/12/7 10:35 上午
 */
public class LockDemo {


  private Lock lock = new ReentrantLock();  //同步锁

  /**
   * synchronized 和 lock的区别
   * <p>
   * Lock 锁  和 synchronized  对比
   * <p>
   * 1. synchronized内置java关键字在jvm层,lock是个java类 是 jdk层的
   * <p>
   * 2. synchronized无法判断是否获取锁的状态,lock可以判断是否获取锁
   * <p>
   * 3. synchronized会自动释放锁,lock必须手动释放锁(unlock()在finally释放) 否则会造成死锁
   * <p>
   * 4. 使用synchronized的两个线程A和B 如果线程A 获得了锁,那么B一定在等待中.如果线程A阻塞了,则线程B
   * <p>
   * 会一直等待下去,lock不一定会等待，如果尝试获取不到锁,线程不会等待,直接结束
   * <p>
   * 5.synchronized适合少量的代码同步,Lock比较适合大量的同步代码的问题
   */

  public void TestLock(Thread thread) {
    lock.lock();  //
    try {
      System.out.println(thread.getName() + "进来了...获取了当前锁...");
      Thread.sleep(2000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }finally {
//      lock.unlock();
//      System.out.println(thread.getName() +"释放锁....");
    }
  }


  public void TestLockNotWait(Thread thread) {
    final boolean b;
    try {
      b = lock.tryLock(1000, TimeUnit.MILLISECONDS);
      if(b){
        System.out.println(thread.getName()+"是否获取到锁"+b);
        try {
          System.out.println(thread.getName() + "进来了...获取了当前锁...");
          Thread.sleep(2000);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }finally {
              lock.unlock();  //lock锁一定要手动释放 不然会产生死锁(如果使用tryLock方法,另一个线程没有获取到锁,就直接结束了)
          //   System.out.println(thread.getName() +"释放锁....");
        }
      }else {
        System.out.println(thread.getName()+"没有获取到锁"+b);
      }

    } catch (InterruptedException e) {
      e.printStackTrace();

    }

  }





}

class TestLock {

  public static void main(String[] args) {
    final LockDemo lockDemo = new LockDemo();

    Thread threadA = new Thread(new Runnable() {
      @Override
      public void run() {
        lockDemo.TestLockNotWait(Thread.currentThread());
      }
    },"线程A");

    Thread threadB = new Thread(new Runnable() {
      @Override
      public void run() {
        lockDemo.TestLockNotWait(Thread.currentThread());
      }
    },"线程B");
    threadA.start();
    threadB.start();
  }
}