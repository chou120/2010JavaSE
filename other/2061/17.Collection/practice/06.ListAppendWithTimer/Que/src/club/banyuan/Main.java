package club.banyuan;

public class Main {

  public static void main(String[] args) {
    Timer time = new TimerImpl();
    time.getTimeMillisecond();
    time.start();
    // 程序空跑，连续执行加法，用来耗时
    for (int i = 0; i < 10000000; ++i) {

    }
    time.stop();
    System.out.println(time.getTimeMillisecond());
  }

}
