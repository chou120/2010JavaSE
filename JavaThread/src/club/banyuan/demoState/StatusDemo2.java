package club.banyuan.demoState;

/**
 * @author sanye
 * @version 1.0
 * @date 2020/12/4 3:32 下午
 */
public class StatusDemo2  extends  Thread {

  private Thread thread;  //用来接受主线程

  public StatusDemo2(Thread thread) {
    this.thread = thread;
  }

  @Override
  public void run() {
    try {
      System.out.println("线程启动：" + Thread.currentThread().getState());
      Thread.sleep(100);
      System.out.println("主线程状态A:" + thread.getState());
      Thread.sleep(1000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}
class  Test{

  public static void main(String[] args) {
    Thread thread = new StatusDemo2(Thread.currentThread());
    System.out.println("线程对象创建，还未调用start：" + thread.getState());
    thread.start();  //自定义线程
   // Thread.sleep(100);
   // System.out.println("线程休眠：" + thread.getState());
  //  thread.join();
  //  System.out.println("线程结束：" + thread.getState());

    try {
      Thread.sleep(10000); //当前线程  主线程
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    System.out.println("主线程状态B:"+Thread.currentThread().getState());  //
    System.out.println("自定义线程状态:"+thread.getState());

  }
}