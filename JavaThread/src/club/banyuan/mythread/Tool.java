package club.banyuan.mythread;

import java.util.concurrent.CountDownLatch;

/**
 * @author sanye
 * @version 1.0
 * @date 2021/7/5 23:12
 */
public class Tool {
    public  static  int index=0;
    public static  CountDownLatch  countDownLatch=new CountDownLatch(2);
    public static boolean flag=true;
}
