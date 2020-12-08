package club.threadHomework;

/**
 * @author sanye
 * @version 1.0
 * @date 2020/12/8 9:03 上午
 */
public class LetterThread extends Thread {

  char ch = 'A';

  @Override
  public void run() {

    //如果说字母线程后抢到怎么修改

    Tool.lock.lock();
    try {
      while (ch<='Z'){
        Tool.condition.await();
        System.out.print(ch+"\t");
        Thread.sleep(500);
        ch++;
        Tool.condition.signal();
      }
    } catch (InterruptedException e) {
      e.printStackTrace();
    }finally {
      Tool.lock.unlock();
    }


  }
}
