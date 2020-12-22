public class StartThread2 implements Runnable {

  // 实现Runnable接口
  // 强制重写run方法
  // 创建一个Thread类的对象，将接口的实现类对象作为构造方法的参数传入
  // 调用Thread类对象的start方法

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
    Thread thread = new Thread(new StartThread2());

    System.out.println("启动了一个线程");

    thread.start();
    System.out.println("在打印一句话");

  }

}
