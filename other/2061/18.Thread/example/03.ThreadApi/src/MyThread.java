public class MyThread extends Thread {

  public MyThread(String name) {
    super(name);
  }

  @Override
  public void run() {
    System.out.println(getName() + "启动");
    System.out.println(getName() + "停止");
  }


  public static void main(String[] args) {
    // 通过这个构造方法创建的时候指定线程的名字。
    Thread thread = new MyThread("新的线程名字");
    thread.start();

    Thread t1 = new MyThread("t1");
    Thread t2 = new MyThread("t2");
    Thread t3 = new MyThread("t3");
    Thread t4 = new MyThread("t4");
    Thread t5 = new MyThread("t5");

    t1.setPriority(Thread.MAX_PRIORITY);
    t2.setPriority(Thread.MIN_PRIORITY);
    t3.setPriority(Thread.NORM_PRIORITY);
    t4.setPriority(Thread.MIN_PRIORITY);
    t5.setPriority(Thread.MAX_PRIORITY);

    t1.start();
    t2.start();
    t3.start();
    t4.start();
    t5.start();

    try {
      // 阻塞，直到指定的线程对象线程执行完成
      t5.join();
      // 等待线程执行完成，如果等了指定的时间之后，继续向下执行
      t5.join(10000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    try {
      Thread.sleep(1000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    // 建议CPU切换线程执行
    Thread.yield();


  }
}
