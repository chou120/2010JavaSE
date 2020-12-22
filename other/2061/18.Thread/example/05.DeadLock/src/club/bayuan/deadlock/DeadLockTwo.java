package club.bayuan.deadlock;

public class DeadLockTwo extends Thread {

  @Override
  public void run() {
    // 获取o1的锁
    synchronized (LockObject.o2) {
      System.out.println("获取o2的锁");
      try {
        Thread.sleep(300);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }

      System.out.println("准备获取o1的锁");
      // 获取o2的锁
      synchronized (LockObject.o1) {
        System.out.println("获取o1的锁成功");
      }
    }


  }
}
