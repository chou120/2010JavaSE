package club.threadHomework;

/**
 * @author sanye
 * @version 1.0
 * @date 2020/12/8 9:03 上午
 */
public class NumberThread extends  Thread{
  int  num=1;

  @Override
  public void run() {
    try {
      Thread.sleep(1000);  //让数字线程的休眠 保证字母线程先抢到
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    Tool.lock.lock();
    try {
      while (num<=52){
        System.out.print(num+""+(num+1));
        num+=2;
        Thread.sleep(500);
        Tool.condition.signal();  //先唤醒在等待
        Tool.condition.await();
      }
    } catch (InterruptedException e) {
      e.printStackTrace();
    }finally {
      Tool.lock.unlock();
    }
  }
}
