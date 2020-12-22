import java.util.Random;

public class CountDemo extends Thread {

  private int count = 0;

  @Override
  public void run() {
    while (count < 500) {
      System.out.println(getName() + "->" + count++);
      // Thread.yield();
      try {
        Thread.sleep(new Random().nextInt(1000));
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }

  public static void main(String[] args) {
    Thread t1 = new CountDemo();
    Thread t2 = new CountDemo();
    t1.setPriority(Thread.MAX_PRIORITY);
    t2.setPriority(Thread.MIN_PRIORITY);
    t1.start();
    t2.start();
  }
}
