package club.banyuan.moon.refine;

/**
 * @author sanye
 * @version 1.0
 * @date 2020/12/7 2:54 下午
 */
public class GetMoon  extends   Thread {
  private Moon moon;

  public GetMoon(Moon moon) {
    this.moon = moon;
  }
  @Override
  public void run() {
      while(true){

      //在获取的时候如果厂家没有生产那么可能会出现获取不到值的情况,重复获取上一次数据
       synchronized (moon) {

         try {
           moon.wait();
         } catch (InterruptedException e) {
           e.printStackTrace();
         }

         if (moon.flag) {
           //当成等待的线程被唤醒,进行获取
           System.out.println("当前月饼名称:" + moon.getName() + ",价格:" + moon.getPrice());
           moon.flag = false;
           //商家消费完了之后要告诉厂家继续生产

         }
       }


    }


  }
}
