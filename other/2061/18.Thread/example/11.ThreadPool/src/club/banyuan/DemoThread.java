package club.banyuan;

public class DemoThread extends Thread {

  @Override
  public void run() {
    System.out.println(getName() + "启动=====");
    try {
      Thread.sleep(5000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    System.out.println(getName() + "退出======");
  }
}
