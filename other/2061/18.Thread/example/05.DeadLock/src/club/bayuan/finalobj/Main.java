package club.bayuan.finalobj;

public class Main {

  public static void main(String[] args) throws InterruptedException {
    DeadLockOne one = new DeadLockOne();
    DeadLockTwo two = new DeadLockTwo();
    one.start();
    // one和two都是获取的新的o2的锁，还是会死锁
    // LockObject.o2 = new Object();
    two.start();
    // one 获取的是新的o2的锁，two获取的是旧的o2的锁，不会出现死锁
    Thread.sleep(10);
    LockObject.o2 = new Object();
  }
}
