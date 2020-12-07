package club.banyuan.moon.refine;

import java.util.concurrent.CountDownLatch;

/**
 * @author sanye
 * @version 1.0
 * @date 2020/12/7 2:55 下午
 */
public class Test {

  public static void main(String[] args) {
    Moon moon = new Moon();
    SetMoon setMoon = new SetMoon(moon);

    GetMoon getMoon = new GetMoon(moon);
    setMoon.start();
    getMoon.start();

    MyThread myThread = new MyThread(moon);
    myThread.start(); //唤醒线程



  }
}
