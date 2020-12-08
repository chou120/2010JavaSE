package club.numberAndLatter;

/**
 * @author sanye
 * @version 1.0
 * @date 2020/12/7 8:50 下午
 */
public class LatterThread extends Thread {

  char ch = 'A';

  @Override
  public void run() {
    Tool.lock.lock();//获取锁对象
    //针对同一个lock对象执行的lock.lock是获得对象监视器的线程才能执行同步代码 其他线程都要等待。
    try {
      //System.out.println(Thread.currentThread().getName()+"进来了...");
      while (ch <= 'Z') {
        //不管怎么样打印字母的线程都是在等待状态
        //Tool.con.await();  //
        System.out.print(ch + "\t");
        Thread.sleep(500);
        ch++;
        //Tool.con.signal();//唤醒正在等待的单个线程
      }
    } catch (InterruptedException e) {
      e.printStackTrace();
    } finally {
       Tool.lock.unlock();//释放锁
      //System.out.println("释放锁Latter");
    }
  }
}
