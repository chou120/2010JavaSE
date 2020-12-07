package club.banyuan.moon;

/**
 * @author sanye
 * @version 1.0
 * @date 2020/12/7 2:54 下午
 */
public class GetMoon  implements  Runnable {
  private  Moon  moon;

  public GetMoon(Moon moon) {
    this.moon = moon;
  }
  @Override
  public void run() {
      while(true) {

        try {
          Thread.sleep((int)(Math.random()*1000));
        } catch (InterruptedException e) {
          e.printStackTrace();
        }

        //if the current thread is not  the owner of the object's monitor   如果当前线程不是对象监视器的所有者
        synchronized (this.moon) {  //以当前对象的moon 作为锁
          //在获取的时候如果厂家没有生产那么可能会出现获取不到值的情况,重复获取上一次数据
          if (moon.flag) {
            //当成等待的线程被唤醒,进行获取
            System.out.println("当前月饼名称:" + moon.getName() + ",价格:" + moon.getPrice());
            moon.flag = false;
            //商家消费完了之后要告诉厂家继续生产
            this.moon.notify();  //只有操作moon当前线程   确定执行锁对象的线程
            try {
              this.moon.wait();  //指的就是GetMoon线程
            } catch (InterruptedException e) {
              e.printStackTrace();
            }
          }

        }
      }
  }
}
