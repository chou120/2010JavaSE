package club.addAndDelThread;

import java.util.concurrent.CountDownLatch;

/**
 * @author sanye
 * @version 1.0
 * @date 2020/12/7 8:28 下午
 */
public class Tool {

  int i = 0;
  CountDownLatch countDownLatch=new CountDownLatch(2);
  boolean flag=true; //用于做判断

}
