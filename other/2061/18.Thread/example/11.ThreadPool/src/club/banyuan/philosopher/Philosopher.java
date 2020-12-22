package club.banyuan.philosopher;

import java.util.Random;

public class Philosopher extends Thread {

  private final Chopstick left;
  private final Chopstick right;
  private int thinkTimes;
  private int eatTimes;

  public Philosopher(String name, Chopstick left, Chopstick right) {
    super(name);
    this.left = left;
    this.right = right;
  }

  @Override
  public void run() {
    while (!Thread.currentThread().isInterrupted()) {
      try {
        if (new Random().nextBoolean()) {
          eat();
        } else {
          think();
        }
      } catch (InterruptedException e) {
        Thread.currentThread().interrupt();
        System.out.println(getName() + "离开了桌子");
      }
    }
  }


  public void eat() throws InterruptedException {
    System.out.println(getName() + "准备开始吃饭");

    if (left.take(getName())) {
      Thread.sleep(30);
      if (right.take(getName())) {
        // 连续获取到了，左边和右边的筷子
        System.out.println(getName() + "开始吃饭");
        Thread.sleep(1000);
        System.out.println(getName() + "吃饭结束");
        right.put(getName());
        eatTimes++;
      } else {
        System.out.println(getName() + "另一只筷子没有拿到");
      }
      left.put(getName());
    } else {
      // 没有获取到左边的筷子，就不再尝试获取右边的筷子，直接不吃了
      System.out.println(getName() + "没有拿到筷子，没吃上饭");
    }

  }

  public void think() throws InterruptedException {
    System.out.println(getName() + "开始思考");
    Thread.sleep(300);
    System.out.println(getName() + "思考结束");
    thinkTimes++;
  }

  public void printResult() {
    System.out.println(getName() + "吃了" + eatTimes + "次饭，思考了" + thinkTimes + "次");
  }
}
