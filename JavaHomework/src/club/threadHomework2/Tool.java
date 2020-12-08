package club.threadHomework2;

import java.util.concurrent.CountDownLatch;

/**
 * @author sanye
 * @version 1.0
 * @date 2020/12/8 9:40 上午
 */
public class Tool {

  public  int  i=0;
  public  final  static  Object  obj=new Object();

  //为了解决高并发的问题   CountDownLatch  类似于一个线程计数器  使一个线程或者多个线程完成各自的工作然后再继续执行
  public  static CountDownLatch countDownLatch=new CountDownLatch(2);// 2表示有两个线程计数器
  public   boolean  flag=false;

}
