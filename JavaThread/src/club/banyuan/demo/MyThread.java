package club.banyuan.demo;

/**
 * @author sanye
 * @version 1.0
 * @date 2020/12/4 1:46 下午
 */
public class MyThread extends Thread {

  public MyThread(String name) {
    super(name);
  }

  /**
   * 多线程是随机执行,并且是抢占cpu的执行权限
   * <p>
   * Thread.currentThread().getName() 获取当前线程执行的名称
   */

  //去创建线程
  @Override
  public void run() {  //线程代码
    for (int i = 0; i < 10; i++) {
      System.out.println(Thread.currentThread().getName() + "阿斯达多撒" + i);  // 当前的三个线程都在抢占cpu资源
    }
  }
}

class TestThead {

  public static void main(String[] args) { //
//    MyThread myThread = new MyThread();
//    myThread.setName("线程A");
//    myThread.start();//不是直接调用run
//    //  myThread.run();
//    // java.lang.IllegalThreadStateException
//    //  myThread.start(); //能不能二次开启同一个线程
//
//    MyThread myThread2 = new MyThread();
//    myThread2.setName("线程B");
//    myThread2.start();//不是直接调用run
////    myThread2.run();
////
//    MyThread myThread3 = new MyThread();
//    myThread3.setName("线程C");
//    myThread3.start();//不是直接调用run
//  //  myThread3.run();
////
//

    // new  Object();  有两个线程在执行

//    MyThread threadA = new MyThread("线程A");
//    threadA.start();
//    MyThread threadB = new MyThread("线程A");
//    threadB.start();
//

  }
}