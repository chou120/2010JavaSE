package club.banyuan.demoJoin;

/**
 * @author sanye
 * @version 1.0
 * @date 2020/12/4 2:43 下午
 */
public class MyThread implements Runnable {

  @Override
  public void run() {
    for (int i = 0; i < 100; i++) {
      System.out.println(Thread.currentThread().getName() + "阿斯达多撒" + i);  // 当前的三个线程都在抢占cpu资源
      /*
       * public static void yield():暂停当前正在执行的线程，并去执行其他线程
       * 可以让多个线程更加和谐，但是还不能保证完全均匀  因为线程是随机执行抢占资源的
       */
      // Thread.yield();
//      try {
//        Thread.currentThread().join(2000);
//      } catch (InterruptedException e) {
//        e.printStackTrace();
//      }
//
//      try {
//        Thread.sleep((int)(Math.random()*1000));  // A     C    B    如果休眠不相同的时间  随机时间休眠
//      } catch (InterruptedException e) {
//        e.printStackTrace();
//      }
    }
  }
}

class Test {

  public static void main(String[] args) {
    MyThread myThread = new MyThread();
    Thread threadA = new Thread(myThread, "线程A");
    Thread threadB = new Thread(myThread, "线程B");
    Thread threadC = new Thread(myThread, "线程C");

    threadA.setPriority(10);  //
    threadB.setPriority(1);
    threadC.setPriority(5);

    threadA.start();
//    try {
//      threadA.join(); //等待线程执行完毕
//    } catch (InterruptedException e) {
//      e.printStackTrace();
//    }
    threadB.start();
    threadC.start();

    System.out.println(threadA.getPriority());
    System.out.println(threadB.getPriority());
    System.out.println(threadC.getPriority());



  }
}