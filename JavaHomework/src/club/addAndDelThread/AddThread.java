package club.addAndDelThread;

import java.util.concurrent.CountDownLatch;

/**
 * @author sanye
 * @version 1.0
 * @date 2020/12/7 8:27 下午
 */
public class AddThread implements Runnable {

  Tool tool;

  public AddThread(Tool tool) {
    this.tool = tool;
  }

  @Override
  public void run() {
    while (true) {
      try {
        Thread.sleep(1000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      synchronized (tool) {
        if (tool.flag) {
          if (tool.countDownLatch.getCount() > 0) {
            tool.countDownLatch.countDown();
            tool.i++;
            System.out.println(Thread.currentThread().getName() + "做了加加操作" + tool.i);
          }else {
            try {
              tool.flag=false;
              tool.countDownLatch.await();
              tool.countDownLatch=new CountDownLatch(2);//用完之后再重新创建两个
            } catch (InterruptedException e) {
              e.printStackTrace();
            }

          }
        }
      }
    }
  }
}
