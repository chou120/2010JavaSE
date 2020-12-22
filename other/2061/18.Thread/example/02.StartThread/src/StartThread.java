public class StartThread extends Thread {

  // 继承Thread类
  // 重写run方法
  // 创建线程类的对象
  // 调用对象的start方法

  // 线程启动之后，需要做什么事情
  @Override
  public void run() {
    int count = 0;
    System.out.println("线程需要做的事情");
    while (true) {
      count++;
      if (count == 100000) {
        break;
      }
    }
    System.out.println("线程退出");
  }

  public static void main(String[] args) {
    StartThread thread = new StartThread();
    thread.start();
    System.out.println("开启了一个线程");
  }
}
