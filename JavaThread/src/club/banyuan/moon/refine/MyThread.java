package club.banyuan.moon.refine;

/**
 * @author sanye
 * @version 1.0
 * @date 2020/12/7 4:19 下午
 */
public class MyThread   extends   Thread{  //唤醒线程
  private  Moon  moon;

  public MyThread(Moon moon) {
    this.moon = moon;
  }
  @Override
  public void run() {
    while(true){
      synchronized (moon){
        moon.notifyAll();//唤醒正在等待的所有线程
      }
    }
  }
}
