package club.banyuan.api2;

import java.util.Random;

/**
 * @author sanye
 * @version 1.0
 * @date 2020/11/26 1:32 下午
 */
public class MathDemo {

  public static void main(String[] args) {
     long round = Math.round(123.592);
     double ceil = Math.ceil(12.04);
     ceil=Math.floor(12.99);

//    System.out.println(Math.pow(3, 2)+"》》》》》》");//指数
//
//      //  3 ~ 20   22   17 0~16 +3
//    for (int i = 0; i <10; i++) {
//      System.out.println(findNumber(3, 20));
//    }

    Random  random=new Random(1000);   //jvm经过多长时间 生成的一个随机数   1000   8
    //final Random random1 = new Random();
//    random.setSeed(100);
//    System.out.println( random.nextInt(10));
//    System.out.println( random.nextInt(10));
//    System.out.println( random.nextInt(10));
//
//    System.out.println(random.nextLong());
//    System.out.println(random.nextLong());
//    System.out.println(random.nextLong());

    Random random1 = new Random(1000);
    Random random2 = new Random(1000);//两个不同的随机对象在1000毫秒值内的随机生成的数据是一样的
    System.out.println(random1.nextInt(10));
    System.out.println(random2.nextInt(10));

//     int i ;
//    for (int j = 0; j <10; j++) {
//      i = random.nextInt(10);
//      System.out.println(i);
//    }

  }

  /**
   * 找出在任意范围内的一个整形随机数
   */
   public static   int   findNumber(int   from,int   to){  // to
      //  1~10
      int  index=(int)(Math.random()*(to-from))+from;
      return   index;
   }
}
