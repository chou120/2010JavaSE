package club.threadHomework2;

import java.util.concurrent.CountDownLatch;

/**
 * @author sanye
 * @version 1.0
 * @date 2020/12/8 9:41 上午
 */
public class AddThread  implements  Runnable{

  Tool  tool;

  public AddThread(Tool tool) {
    this.tool = tool;
  }

  @Override
  public void run() {
     while(true){

       synchronized (tool) {//
         if (!tool.flag) {
           if (Tool.countDownLatch.getCount() > 0) { //初始有两个线程计数器
             System.out.println(Thread.currentThread().getName() + "在执行加线程" + (++tool.i));
             Tool.countDownLatch.countDown();//每执行一次线程计数器会减少一个
           } else { //如果线程计数器用完了就去创建,当前线程进入等待状态
             try {
               tool.flag=true;
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
