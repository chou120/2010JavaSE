package club.banyuan.deamon;

public class Demo extends Thread {

  public Demo(String name) {
    super(name);
  }

  @Override
  public void run() {
    // this 指代的是调用run方法的对象
    // Thread.currentThread 返回的是正在执行的线程对象，线程对象未必是run方法的调用对象
    System.out.println(this.getName());
    System.out.println(Thread.currentThread().getName());
    System.out.println(this == Thread.currentThread());
  }

  public static void main(String[] args) throws InterruptedException {
    // Thread thread = new Demo("DemoThread");
    // // thread.start();
    //
    // Thread t1 = new Thread(thread);
    // t1.start();

    // ExecutorService executorService = Executors.newSingleThreadExecutor();
    // executorService.execute(thread);

    Thread thread = new Thread(new Runnable() {
      @Override
      public void run() {
        try {
          Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
              while (true) {
                System.out.println("1");
              }
            }
          });
          t1.setDaemon(true);
          t1.start();
          Thread.sleep(1000);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
    });
    // 设置了一个守护线程，当进程中最后一个非守护线程执行完毕后，所有的守护线程停止执行。
    // thread.setDaemon(true);
    thread.start();
    thread.join();
    Thread.sleep(2000);
    System.out.println("线程退出");
  }
}
