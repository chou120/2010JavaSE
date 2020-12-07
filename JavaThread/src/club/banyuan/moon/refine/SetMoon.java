package club.banyuan.moon.refine;

/**
 * @author sanye
 * @version 1.0
 * @date 2020/12/7 2:49 下午
 */
public class SetMoon  extends   Thread{

  private Moon moon;

  int   x=0;
  public SetMoon(Moon moon) {
    this.moon = moon;
  }

  @Override
  public void run() {
       //生产一个月饼
    while (true) {

      synchronized (moon) {

        try {
          moon.wait();
        } catch (InterruptedException e) {
          e.printStackTrace();
        }

        //判断月饼是否被生产出来
        if (!moon.flag) {
          if (x % 2 == 0) {
            moon.setName("蛋黄月饼");
            moon.setPrice(7.0);
          } else {
            moon.setName("水果月饼");
            moon.setPrice(1.0);
          }
          System.out.println("--------------月饼已经生产好了:" + moon.toString());
          moon.flag = true;
          x++;
          // moon.notify();//唤醒的是操作正在等待的线程(作用在GetMoon上面的线程)
          //如果月饼生产好了就等待

        }

      }
    }
  }
  /**
   *  中秋节要到了,现在拜托厂家(SetMoon)生产月饼(Moon)，一种是蛋黄月饼,一种是水果月饼
   *    要有订单去告诉厂家生产月饼
   *    GetMoon   一般是厂家如果有月饼 才能进货 并且售卖
   */
    //厂家生产一个   卖家就可以卖一个

}
