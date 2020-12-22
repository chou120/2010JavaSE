package club.banyuan.product;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ProductLock {

  public static Lock lock = new ReentrantLock();
  public static Condition productCondition = lock.newCondition();
  public static Condition consumerCondition = lock.newCondition();

}
