package club.banyuan.demoDieLock;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author sanye
 * @version 1.0
 * @date 2020/12/7 1:37 下午
 */
public class Tool {

  public  static final Object OBJECT1=new Object();
  public  static final Object OBJECT2=new Object();

//  public  static final Lock lock=new ReentrantLock();
   public static  final Semaphore  semaphore1=new  Semaphore(1);//一次只允许一个线程通过,等当前线程调用release()释放令牌,别的线程才可以使用
   public static  final Semaphore  semaphore2=new  Semaphore(1);//一次只允许一个线程通过,等当前线程调用release()释放令牌,别的线程才可以使用

}
