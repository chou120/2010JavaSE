package club.threadHomework2;

import java.util.concurrent.CountDownLatch;

/**
 * @author sanye
 * @version 1.0
 * @date 2020/12/8 9:41 上午
 */
public class DelThread implements  Runnable{

  Tool tool;

  public DelThread(Tool tool) {
    this.tool = tool;
  }

  @Override
  public void run() {
    while(true){
      synchronized (tool) {//
        if (tool.flag) {  //用来控制是哪一种线程先走
          if (Tool.countDownLatch.getCount() > 0) {  //线程计数器用完了 另一种线程再继续执行
            System.out.println(Thread.currentThread().getName() + "在执行减线程" + (--tool.i));
            Tool.countDownLatch.countDown(); //线程执行一次 线程计数器就会自减一次  等两个减线程执行完了 线程计数器为0 如果要让加线程继续执行,就要给加线程创建一个线程计数器
          } else {//如果线程计数器用完了就去创建,当前线程进入等待状态
            try {
              tool.flag=false;
              Tool.countDownLatch.await();
              Tool.countDownLatch = new CountDownLatch(2);
            } catch (InterruptedException e) {
              e.printStackTrace();
            }
          }
        }
      }
      try {
        Thread.sleep(1000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }

  }

}
