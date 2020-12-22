package club.banyuan.philosopher;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Chopstick {

  private String id;
  private boolean isTaken;
  private Lock lock = new ReentrantLock();

  public Chopstick(String id) {
    this.id = id;
  }

  public boolean take(String name) throws InterruptedException {
    // 尝试获取这一只筷子，如果这个筷子已经被别人获取到了，方法将返回false
    System.out.println(name + "尝试拿起筷子" + id);
    if (!lock.tryLock(1, TimeUnit.SECONDS)) {
      System.out.println(name + "没有拿到筷子" + id);
      return false;
    }
    isTaken = true;
    System.out.println("筷子" + id + "被" + name + "拿起！");
    return true;
  }

  public void put(String name) {
    isTaken = false;
    System.out.println("筷子" + id + "被" + name + "放下！");
    lock.unlock();
  }

}
