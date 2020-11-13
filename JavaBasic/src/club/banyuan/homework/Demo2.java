package club.banyuan.homework;

import java.util.Scanner;

/**
 * @author sanye
 * @version 1.0
 * @date 2020/11/13 1:36 下午
 */
public class Demo2 {

  /**
   * 1.从键盘输入一个班5个学生的分数，求和并输出
   * 2.从键盘输入某个十进制整数数，转换成对应的二进制整数并输出。
   *
   */
  public static void main(String[] args) {

//    double[] arr = {12,3,4,56,1.9};
//    double v = sum_arr(arr);

    Scanner scanner=new Scanner(System.in);
    System.out.println("请输入一个数据:");
    int num= scanner.nextInt();  //   12

    /**
     *  12%2 ..... 0
     *  6%2 .......0
     *  3%2 .......1
     *  1
     *   1100
     */

//     String binarch = binarch(num);
//    System.out.println("二进制数是:"+binarch);






  }
  public  static  String  binarch(int  number){
    /**
     *
     */
    int  key=-1;
    String  str="";
    while (number!=0){
      key=number%2;  //  0    12%2...0    6%2 ....0  3%2 ..1   1%2 ...  1
      number=number/2;  //    12/2 ...6    6/2 =3     3/2   1
        // 6     number==3      number ==1
      str=key+str;    //  0+""   0+"0"   1+"00"  key+"100"
    }
    return str;
  }

  private static double sum_arr(double[] arr) {
    double sum = 0;
    for (int i = 0; i < arr.length; i++) {
      sum += arr[i];
    }
    return sum;
  }


}
