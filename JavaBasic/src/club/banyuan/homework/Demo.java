package club.banyuan.homework;

import java.util.Scanner;

/**
 * @author sanye
 * @version 1.0
 * @date 2020/11/11 9:10 上午
 */
public class Demo {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.println("请输入第1个数:");
    int number1=scanner.nextInt();
    System.out.println("请输入第2个数:");
    int number2=scanner.nextInt();
    System.out.println("请输入第3个数:");
    int number3=scanner.nextInt();
    int max = number1;
    if(max<number2){
      max=number2;
    }
    if(max<number3){
      max=number3;
    }
    System.out.println(max);
  }
}
