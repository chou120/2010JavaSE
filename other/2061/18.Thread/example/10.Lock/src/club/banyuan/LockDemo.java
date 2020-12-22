package club.banyuan;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockDemo extends Thread {

  static Lock lock = new ReentrantLock();
  static Condition condition = lock.newCondition();
  static Condition condition1 = lock.newCondition();
  static Condition condition2 = lock.newCondition();


  @Override
  public void run() {

    System.out.println(getName() + "线程启动");
    // lock.lock();
    // 尝试获取锁，如果获取不到锁，则返回false
    if (!lock.tryLock()) {
      System.out.println(getName() + ":尝试获取锁，但是没有拿到，结束运行");
      return;
    }
    try {
      // try {
      //   if (!lock.tryLock(2, TimeUnit.SECONDS)) {
      //     System.out.println(getName() + ":尝试获取锁，但是没有拿到，结束运行");
      //     return;
      //   }
      // } catch (InterruptedException e) {
      //   e.printStackTrace();
      // }

      System.out.println(getName() + "线程获取到锁");
      try {
        Thread.sleep(1000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      System.out.println(getName() + ":准备释放锁");
      // lock.unlock();
      System.out.println(getName() + "释放锁，线程退出");
    } finally {
      lock.unlock();
    }
  }

  public static void main(String[] args) {
    LockDemo t1 = new LockDemo();
    LockDemo t2 = new LockDemo();
    t1.start();
    t2.start();
  }
}
