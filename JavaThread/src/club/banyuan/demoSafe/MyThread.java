package club.banyuan.demoSafe;

import java.util.Map;

/**
 * @author sanye
 * @version 1.0
 * @date 2020/12/4 4:01 下午
 */
public class MyThread implements Runnable {
  Integer ticket =200;   //同一个资源
  final  User  user=new User(); //

  @Override
  public void run() {
      //战狼2  1000   --->>  100
    while (true){
      try {
        Thread.sleep((int)(Math.random()*1000));
        //  Thread.sleep(1000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      if(ticket<1){
        break;
      }
      //
      synchronized (this){ //   synchronized (锁对象){  }   锁对象可以是任意的  一般情况下 锁对象是唯一的
        System.out.println(Thread.currentThread().getName()+"进来了....");
            /**
             * 在休眠的情况下,可能会出现抢到同样的票数,或者可能抢到负的票数 这是数据不安全
             *
             * 在上述情况下,资源是统一的,执行环境是多线程的,没法改变,尝试去给多线程执行的代码进行加锁
             *    synchronized
             *
             */
        try {
          Thread.sleep(10000);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+"抢到了第"+(ticket--)+"张票");
      }
    }
  }
}

class Test {

  public static void main(String[] args) {
    MyThread myThread = new MyThread();
    new Thread(myThread, "线程A").start();
    new Thread(myThread, "线程B").start();
    new Thread(myThread, "线程C").start();
  }
}
class  User{

}

