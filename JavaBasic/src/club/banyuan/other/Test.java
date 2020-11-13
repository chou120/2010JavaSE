package club.banyuan.other;

/**
 * @author sanye
 * @version 1.0
 * @date 2020/11/12 8:57 下午
 */
public class Test {

  /**
   * 7.输入一个正整数，将该数的各位左右反转输出，即输入123，输出321。（使用while循环实现）
   *
   * @param args
   */

  /**
   * 54321 5432 543 54 5
   *
   * @param args
   */

  public static void main(String[] args) {

//    int num = 1234;
//
//    System.out.println(numberRevese(num));

//    for (int i = 1; i<=5; i++) {
//      for (int j = 5; j >=i; j--) {
//        System.out.print(j);
//      }
//      System.out.println();
//    }

//    int [] arr={12,3141,1,31,31,4,1,23,155,2,31235,125,65};
//
//    System.out.println(findMaxAndOutIndex(arr));

    int[] numberTime = findNumberTime();
    for (int i = 0; i <numberTime.length ; i++) {
      System.out.println("下标为:"+i+",出现的次数为:"+numberTime[i]);
    }


  }

  private static int[] findNumberTime() {
    //创建一个10个长度的数组
    int[] ints = new int[10];

    for (int i = 0; i < 30; i++) {
      int number = (int) (Math.random() * 10);
      for (int j = 0; j < ints.length; j++) {
        if(number==j){
          ints[j]++;
        }
      }
    }
  return ints;
  }

  private static String findMaxAndOutIndex(int[] arr) {
    int max = arr[0];
    int index = -1;
    for (int i = 1; i < arr.length; i++) {
      if (max < arr[i]) {
        max = arr[i];
        index = i;
      }
    }
    return "最大值是:" + max + ",其在数组中的下标为:" + index;
  }

  public static String numberRevese(int number) {
    String str = "";
    int key = -1;
    int mod = -1;
    while (number != 0) {
      key = number % 10;  //得到余数 也就是个位数
      mod = number / 10;  //得到商
      number = mod;  //把商重新赋值给number
      str = str + key;
    }

    return str;

  }


}
