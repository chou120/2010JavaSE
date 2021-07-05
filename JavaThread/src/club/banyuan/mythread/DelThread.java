package club.banyuan.mythread;

import java.util.concurrent.CountDownLatch;

/**
 * @author sanye
 * @version 1.0
 * @date 2021/7/5 23:12
 */
public class DelThread implements Runnable {
    @Override
    public void run() {
        while (true) {

            if (!Tool.flag) {
                synchronized (Tool.class) {

                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    if (Tool.countDownLatch.getCount() > 0) {
                        System.out.println(Thread.currentThread().getName() + "deling: ------" + (--Tool.index));
                        Tool.countDownLatch.countDown();//每执行一次  里面的线程通道就减少一个

                       /* try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
*/
                        Tool.class.notify();
                        try {
                            Tool.class.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                    } else {
                        Tool.flag = true;
                        Tool.countDownLatch = new CountDownLatch(2);
                    }

                }
            }else{

                try {
                   // System.out.println(Thread.currentThread().getName() + ":waiting...");
                    Tool.countDownLatch.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
