package club.banyuan.arrayPra;

import java.util.Scanner;

/**
 * @author sanye
 * @version 1.0
 * @date 2020/11/16 1:46 下午
 */
public class MyArrays {

  /**
   * 二维数组
   */
  public static void main(String[] args) {
    //格式:数据类型[][] 数组名=new 数据类型[3][4];  动态数组
    // 数据类型[][] 数组名={{},{},{}};
    int[][] arr = new int[2][];
    arr[0] = new int[3]; //  给第1个数组里面的地址分配一个长度为3的一维数组
    arr[1] = new int[5]; //  给第2个数组里面的地址分配一个长度为5的一维数组
    //arr[2]=new int[6]; //  给第3个数组里面的地址分配一个长度为6的一维数组

//    arr[0][0]=12312;
//    arr[0][1]=12312;
//    arr[0][2]=12312;
//
//    arr[1][0]=12312;
//    arr[1][1]=12312;
//    arr[1][2]=12312;
//    arr[1][3]=12312;

    Scanner scanner = new Scanner(System.in);
    for (int i = 0; i < arr.length; i++) {
      for (int j = 0; j < arr[i].length; j++) {
        arr[i][j] = scanner.nextInt();
      }
    }






  }
}
