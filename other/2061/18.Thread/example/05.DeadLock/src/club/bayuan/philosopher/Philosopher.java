package club.bayuan.philosopher;

import java.util.Random;

public class Philosopher extends Thread {

  private final Chopstick left;
  private final Chopstick right;

  public Philosopher(String name, Chopstick left, Chopstick right) {
    super(name);
    this.left = left;
    this.right = right;
  }

  @Override
  public void run() {
    while (true) {
      try {
        if (new Random().nextBoolean()) {
          eat();
        } else {
          think();
        }
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }


  public void eat() throws InterruptedException {
    System.out.println(getName() + "准备开始吃饭");
    synchronized (left) {
      left.take(getName());
      Thread.sleep(30);
      synchronized (right) {
        right.take(getName());
        System.out.println(getName() + "开始吃饭");
        Thread.sleep(1000);
        System.out.println(getName() + "吃饭结束");
        right.put(getName());
        left.put(getName());
      }
    }
  }

  public void think() throws InterruptedException {
    System.out.println(getName() + "开始思考");
    Thread.sleep(300);
    System.out.println(getName() + "思考结束");
  }
}
