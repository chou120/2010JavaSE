package club.banyuan.demoInterrupter;

import java.util.Date;

/**
 * @author sanye
 * @version 1.0
 * @date 2020/12/4 3:02 下午
 */
public class MyThread  implements  Runnable {

  @Override
  public void run() {
    System.out.println("开始时间：" + new Date());
    try {
      Thread.sleep(1000);  //  10
    } catch (InterruptedException e) {
      //e.printStackTrace();
      System.out.println(Thread.currentThread().getName()+"线程被中断");
    }
    //当前线程停止了
    System.out.println("结束时间：" + new Date());
  }
}
class Test{
  public static void main(String[] args) {
    final MyThread myThread = new MyThread();
    final Thread thread = new Thread(myThread, "线程A");
    thread.start();
    try {
      System.out.println(Thread.currentThread().getName()+"在休眠");
      Thread.sleep(10000);  //3
      //thread.interrupt();
      thread.stop();  //线程停止
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}