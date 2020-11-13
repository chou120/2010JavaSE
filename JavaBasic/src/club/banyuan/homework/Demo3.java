package club.banyuan.homework;

import java.util.Scanner;

/**
 * @author sanye
 * @version 1.0
 * @date 2020/11/13 1:58 下午
 */
public class Demo3 {

  /**
   * 3.输入一批整数，使用循环求出最大值与最小值，输入0时结束。
   */
  public static void main(String[] args) {
    //

    System.out.println(getMaxAndMin());

  }

  public static String getMaxAndMin() {
    Scanner scanner = new Scanner(System.in);
    System.out.println("请输入一个数:");
    int num = scanner.nextInt();
    int max = num;
    int min = num;

    while(num!=0){
      if(num>max){
        max=num;
      }
      if(num<min){
        min=num;
      }
      System.out.println("请输入一个数:");
      num = scanner.nextInt();
    }
    return "最大值是:" + max + ",最小值是:" + min;
  }


}
