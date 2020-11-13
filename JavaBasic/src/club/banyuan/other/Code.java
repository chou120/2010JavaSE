package club.banyuan.other;

import java.util.Scanner;

/**
 * @author sanye
 * @version 1.0
 * @date 2020/11/13 9:21 上午
 */
public class Code {

  /**
   * 1.你的程序要读入一系列正整数数据，输入-1表示输入结束，-1本身不是输入的数据。
   *    程序输出读到的数据中的奇数和偶数的个数。
   * 	输入格式:一系列正整数，整数的范围是（0,100000）。
   * 	如果输入-1则表示输入结束。
   * 	输出格式：两个整数，第一个整数表示读入数据中的奇数的个数，
   * 	第二个整数表示读入数据中的偶数的个数。两个整数之间以空格分隔。
   * @param
   */

  public  static  String  count(int start,int  end){
    String  str="";
    int  jKey=0;//表示奇数个数
    int  oKey=0;//表示偶数个数
    Scanner scanner=new Scanner(System.in);
    System.out.println("请输入数据:");
    int number=scanner.nextInt();
    while(true){
      if(number==-1){
        System.out.println("您输入的数据是"+number+",程序结束...");
        break;
      }
     if(number<0 || number>1000){
       System.err.println("输入的数据不在范围内,请重新输入:");
       number = scanner.nextInt();
     }
      if(number%2==0){
        oKey++;
      }else {
        jKey++;
      }
      System.out.println("请再次输入:");
      number = scanner.nextInt();
    }
    str=str+"偶数有:"+oKey+"个,奇数有:"+jKey+"个";
    return str;
  }



  public static void main(String[] args) {

    String count = count(1,200);

    System.out.println(count);

  }

}
