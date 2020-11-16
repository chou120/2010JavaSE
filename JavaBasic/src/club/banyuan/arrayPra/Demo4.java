package club.banyuan.arrayPra;

import java.util.Arrays;

/**
 * @author sanye
 * @version 1.0
 * @date 2020/11/16 2:57 下午
 */
public class Demo4 {

  /**
   * 2:数据加密问题 某个公司采用公用电话传递数据信息，数据是小于8位的整数(默认8位)，为了确保安全， 在传递过程中需要加密，加密规则如下：
   * 首先将数据倒序，然后将每位数字都加上5，再用和除以10的余数代替该数字， 87654321   8+5=13%10=3 最后将第一位和最后一位数字交换。 请任意给定一个小于8位的整数，
   * 然后，把加密后的结果在控制台打印出来
   */
  public static void main(String[] args) {
    int number = 87650321;  //  12345678
    int[] arr = new int[8];  //  (8+5)%10  ------  3
    int  key=-1;
    int index=0;
    while (true) {
      key=number%10;  //  1   6
      arr[index++]=(key+5)%10;
      if(index==8){
        System.out.println("去各自位数已经结束");
        break;
      }
      number=number/10;
    }
    int  temp =arr[0];
    arr[0]=arr[arr.length-1];
    arr[arr.length-1]=temp;
    System.out.println(Arrays.toString(arr));

  }


}
