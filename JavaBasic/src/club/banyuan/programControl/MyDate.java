package club.banyuan.programControl;

import java.util.Scanner;

/**
 * @author sanye
 * @version 1.0
 * @date 2020/11/10 3:56 下午
 */
public class MyDate {

  /**
   * 课堂练习 1.使用switch 该写 四季练习
   * <p>
   * 2.判断输入month月 date 号 是今年的第多少天 2020 month是手动输入的月份 date 是手动输入的天数
   * <p>
   * 3.改写第二题,判断输入的年份year是否是闰年,并且得到是year年的第多少天 year 是手动输入的年份
   */
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.println("请输入月份:");
    int month = scanner.nextInt();
    System.out.println("请输入几号:");
    int date = scanner.nextInt(); //10

    int sum = 0;

    //1 3  5 7 8 10 12  31天
    //4 6 9 11 30天
    //2 闰年  29天
    switch (month-1) {   //   1  5
      case 11:  //表示的是12月份
        sum = sum + 30;
      case 10:
        sum = sum + 31;
      case 9:
        sum=sum+30;
      case 8:
        sum=sum+31;
      case 7:
        sum=sum+31;
      case 6:
        sum=sum+30;
      case 5:
        sum=sum+31;
      case 4:
        sum=sum+30;
      case 3:
        sum=sum+31;
      case 2:
        sum=sum+29;
      case 1:
        sum=sum+31;  //已经过去的1月份
      case 0:
        sum=sum+date;
        break;
      default:
        sum=0;
        break;

    }
    System.out.println("sum是2020年的第"+sum+"天");

  }

}
