package club.banyuan.oop;

import java.util.Arrays;

/**
 * @author sanye
 * @version 1.0
 * @date 2020/11/16 3:12 下午
 */
public class Demo1 {

  /**
   * C  面向过程的语言:  所有的程序,都要自己亲力亲为,自己完成
   * <p>
   * java 面向对象的语言: 拿来主义
   */
  public static void main(String[] args) {

    int[] arr = {12, 33, 11, 21, 5, 89, 7, 54};
//    int sum = getSum(arr);
//    System.out.println("求和:" + sum);
//    final int max = getMax(arr);
//    //final int max = getMax(arr);
//    System.out.println("求最大值:" + max);
//
//    String str = getStr(arr);
//    System.out.println("打印数组的结果:" + str);

    Arrays.sort(arr);
    System.out.println(Arrays.toString(arr));





  }

  //数组求和
  public static int getSum(int[] arr) {
    int sum = 0;
    for (int i = 0; i < arr.length; i++) {
      sum += arr[i];
    }
    return sum;
  }


  //数组求最大值
  public static int getMax(int[] arr) {
    int max = arr[0];
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] > max) {
        max = arr[i];
      }
    }
    return max;
  }


  //数组输出
  // [12,213,12,512,5657]
  public static String getStr(int[] arr) {
    String str = "[";
    for (int i = 0; i < arr.length; i++) {
      if (i == arr.length - 1) {
        str = str + arr[i] + "]";
      } else {
        str = str + arr[i] + ",";
      }
    }
    return str;
  }


}
