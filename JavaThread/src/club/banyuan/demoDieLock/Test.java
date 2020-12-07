package club.banyuan.demoDieLock;

/**
 * @author sanye
 * @version 1.0
 * @date 2020/12/7 1:39 下午
 */
public class Test {

  public static void main(String[] args) {

    final Thread thread = new Thread(new DieLockDemo(), "线程A");
     //链式书写
    final Thread thread1 = new Thread(new DieLockDemo2(), "线程B");
    thread.start();
//    try {
//      thread.join();
//    } catch (InterruptedException e) {
//      e.printStackTrace();
//    }
    thread1.start();
  }
}
