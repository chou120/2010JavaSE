package club.bayuan.deadlock;

public class Main {

  public static void main(String[] args) {
    DeadLockOne one = new DeadLockOne();
    DeadLockTwo two = new DeadLockTwo();
    one.start();
    two.start();
  }
}
