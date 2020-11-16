package club.banyuan.arrayPra;

import java.util.Arrays;

/**
 * @author sanye
 * @version 1.0
 * @date 2020/11/16 2:27 下午
 */
public class Demo3 {

  public static void main(String[] args) {
    int[] ints = new int[10];  //存放下标出现的次数  0  0  0
    /**
     * 拿到数组  其实就是利用数组的下标  对随机出来的 数进行比较
     *  下标所执向的数组里面的元素如果出现本身自加1
     */
    for (int i = 0; i <30; i++) {
      int v = (int)(Math.random() * 10); // 随机一个数  0~9
      System.out.println("随机出来的数据为:"+v);
      for (int j = 0; j < ints.length; j++) { //  10
        if(j==v){  // 0   j是用来存放次数的数组的下标跟随机数相比进行判断
          //ints[j]=++ints[j];  //数组下标所指向的数据本身自加1
          ++ints[j];
          // break;
        }
      }
    }
    for (int i = 0; i <ints.length; i++) {
      System.out.println("下标是:"+i+"出现的次数:"+ints[i]);
    }
  }
  /**
   * 有30个0~9之间的数字，分别统计0~9这10个数字分别出现了多少次
   *
   *  0  1  2  3  4  5  6  7  8  9
   */







}
