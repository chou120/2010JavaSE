package club.banyuan.demoState;

/**
 * @author sanye
 * @version 1.0
 * @date 2020/12/4 3:19 下午
 */
public class MyThread  implements  Runnable {

  @Override
  public void run() {
    try {
      System.out.println("线程启动：----2" + Thread.currentThread().getState());  //获取当前线程状态
      Thread.sleep(10000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

  }
}
class TestMyThread{

  public static void main(String[] args) {
    MyThread myThread=new MyThread();
    Thread  thread=new  Thread(myThread);
    System.out.println("线程对象创建，还未调用start：---1" + thread.getState());
    thread.start();
//    try {
//      Thread.sleep(100);  //当前线程休眠
//      System.out.println("---- 3" + thread.getState());  //自定义线程结束
//    } catch (InterruptedException e) {
//      e.printStackTrace();
//    }

    try {
      thread.join();    //让别的线程等待
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    System.out.println("当前main线程的状态:--- "+Thread.currentThread().getState());
    System.out.println("线程结束：" + thread.getState());  //

  }
}
