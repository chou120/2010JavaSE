package club.banyuan.mythread;

import java.util.concurrent.CountDownLatch;

/**
 * @author sanye
 * @version 1.0
 * @date 2021/7/5 23:08
 */
public class AddThread implements Runnable {

    @Override
    public void run() {
        while (true) {


            if (Tool.flag) {
                synchronized (Tool.class) {

                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    if (Tool.countDownLatch.getCount() > 0) {
                        System.out.println(Thread.currentThread().getName() + "adding:++++++" + (++Tool.index));
                        Tool.countDownLatch.countDown();//每执行一次  里面的线程通道就减少一个
                       // System.out.println("----" + Tool.countDownLatch.getCount());


                        Tool.class.notify();
                        try {
                            Tool.class.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    } else {
                        Tool.flag = false;
                        Tool.countDownLatch = new CountDownLatch(2);
                    }



                }
            }else{

                try {
                    Tool.countDownLatch.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
