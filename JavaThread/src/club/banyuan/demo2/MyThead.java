package club.banyuan.demo2;

/**
 * @author sanye
 * @version 1.0
 * @date 2020/12/4 2:04 下午
 */
public class MyThead implements Runnable {
  @Override
  public void run() {
    for (int i = 0; i < 10; i++) {
      System.out.println(Thread.currentThread().getName() + "阿斯达多撒" + i);  // 当前的三个线程都在抢占cpu资源
      try {
        Thread.sleep((int)(Math.random()*1000));  // A     C    B    如果休眠不相同的时间  随机时间休眠
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }
}

class TestRunnable {

  public static void main(String[] args) {

    MyThead myThread = new MyThead();  //如果去实现Runnable接口 就要创建线程启动对象

    Thread threadA = new Thread(myThread, "线程A");
    threadA.start();
    Thread threadB = new Thread(myThread, "线程B");
    threadB.start();
    Thread threadC = new Thread(myThread, "线程C");
    threadC.start();



  }
}