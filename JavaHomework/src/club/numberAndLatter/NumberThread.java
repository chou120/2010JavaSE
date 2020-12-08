package club.numberAndLatter;

/**
 * @author sanye
 * @version 1.0
 * @date 2020/12/7 8:50 下午
 */
public class NumberThread extends Thread {

  int num = 1;
  @Override
  public void run() {
    Tool.lock.lock();
    System.out.println(Tool.lock.tryLock());
    try {
      while (num <=52) {
        System.out.print(num + "" + (num + 1));
        num=num+2;
        Thread.sleep(500);
        //Tool.con.signal();  //唤醒正在等待的线程
        //Tool.con.await();
      }
    } catch (InterruptedException e) {
      e.printStackTrace();
    }finally {
      Tool.lock.unlock();
    //  System.out.println("释放锁number");
    }
  }
}
