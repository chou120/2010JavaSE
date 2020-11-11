package club.banyuan.circulation;

import java.util.Scanner;

/**
 * @author sanye
 * @version 1.0
 * @date 2020/11/11 9:16 上午
 */
public class Demo {

  public static void main(String[] args) {
    /**
     * for (初始化值;判断条件;步长){
     *   代码块;
     * }
     *
     * 初始化值;
     * while(判断条件){
     *   代码块;
     *   步长;
     * }
     *
     *  初始化值;
     * do{
     *    代码块;
     * }while(条件);
     */
    /**
     * for(1;2;4){
     *   3;
     * }
     */

//    for (int i = 0; i < 10;i++) {
////      System.out.println("第"+(i+1)+"次循环得到的值是:"+i);
//      for (int j = 0; j < 10;j++) {
//        System.out.println("外面第"+(i+1)
//            +"次循环,内部"+"第"+(j+1)+"次循环,得到的值是:"+j);
//      }
//    }

    //求20以内是5的倍数的数据
//    for (int i = 0; i < 20; i++) {
//      if (i % 5 == 0) {
//        System.out.println(i + "是5的倍数");
//      }
//    }
//
//
//    for (int i=0;true;i++){
//      System.out.println("哈撒给"+i);
//    }

    //打印九九乘法表
//      1*1=1
//      1*2=2 2*2=4
//      。。。。。。。。
//      1*9=9 。。。。。  9*9=81
//
//

    //第一行 有一行一列
    //   9     1   9

    for (int i = 1; i < 10; i++) {  //i  表示行
      for (int j = 1; j <= i; j++) { // j 表示列
        System.out.print(j + "*" + i + "=" + (i * j) + "  ");
      }
      System.out.println();
    }

    /**
     *  n   n
     */

    /**
     * 1.请打印出以下图形
     * 1
     * 23
     * 456
     * 78910
     */

//    int  key=1;
//    for (int i = 1; i <=4; i++) {
//      for (int j = 1; j <=i; j++) {
//        System.out.print(key++%10);
//      }
//      System.out.println();
//    }
//
//    int i = 0;
//    for (;i < 10; i++) {
//      System.out.println(i);
//    }
//    System.out.println(i);  //
//
    int num = 12;
    boolean flag = true;
    if (num < 15) {
      flag = false;
    }
    while (flag) {
      System.out.println("不断学习" + num);
      num--;
    }

//    int  x=0;
//    do{
//      System.out.println(x);
//      x--;
//    }while (x<-5);

    /**
     * 请输入任意数字,当输入的数字是0的时候停止输入
     */
    Scanner scanner = new Scanner(System.in);
    System.out.println("请输入:");
    int zero = scanner.nextInt();
    while (true) {
      System.out.println("输入的数字为:" + zero);
      if (zero == 0) {
        System.out.println("输入的数为0,程序结束....");
        break;//跳出当前循环
      }
      zero = scanner.nextInt();
    }
    // System.out.println("程序结束");
    /**
     *
     *  猜数字游戏
     *      随机获取一个数字
     *       int  number  =(int)(Math.random()*50);//随机获取50以内的随机数  有五次机会
     *       如果五次都猜不对就结束程序
     *       每一次猜的时候给出猜的结果  比如说  5>number  输出  "大了" 以此类推
     *
     */


  }
}
