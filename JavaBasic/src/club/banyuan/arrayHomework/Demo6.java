package club.banyuan.arrayHomework;

import java.util.Arrays;

/**
 * @author sanye
 * @version 1.0
 * @date 2020/11/12 10:09 上午
 */
public class Demo6 {
  /**
   * 编写一个方法用于int数组去重，将数组中重复的元素只保留一个
   */

  public  static int [] filterArray(int[]arr){

    //{1, 3, 3, 1, -3, -9, 12, 33};

    /**
     * 1
     *   3, 3, 1, -3, -9, 12, 33
     * 0 1  2  3   4   5   6  7
     */
    int  key=0;
    int [] newArray=new int[arr.length];
    for (int i = 0; i < arr.length; i++) {
      boolean flag=true;  //true 表示没有重复的数字
      for (int j = i+1; j < arr.length; j++) {
        if(arr[i]==arr[j]){
              flag=false;
              break;
        }
      }
      if(flag){  //false
        newArray[key++]=arr[i];  //
      }
    }
    //  [3, 1, -3, -9, 12, 33,0,0]
    int[] infoArray = new int[key];
    System.out.println("----"+infoArray.length);
    for (int i = 0; i < infoArray.length; i++) {
        infoArray[i]=newArray[i];
    }
    return infoArray;
  }

  public static void main(String[] args) {
    int[] ints = {1, 3, 3, 1, -3, -9, 12, 33};  // 3  1 -3 -9 12 33

    System.out.println(Arrays.toString(filterArray(ints)));

  }


}
