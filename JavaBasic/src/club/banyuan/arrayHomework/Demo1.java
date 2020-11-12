package club.banyuan.arrayHomework;

import java.util.Arrays;

/**
 * @author sanye
 * @version 1.0
 * @date 2020/11/12 9:05 上午
 */
public class Demo1 {

  /**
   *  编写一个sortArr方法
   * @param args
   */
  public static void main(String[] args) {
    int [] arr={123,4112,11,22,5,13};

    sort(arr,false);

    System.out.println(Arrays.toString(arr));

    String  str=null;
    System.out.println(str);

    // 将数组里面的数据以字符串的形式输出
    str="(";

    for (int i = 0; i < arr.length; i++) {
      str=str+arr[i]+"+";
    }
    str=str+")";
    System.out.println(str);
    //将整形数字变成字符串
    int number=12;
    int  number2=123;

    String  ss=""+number; //字符串12








  }

  /**
   * 根据传入的参数来将数组升序或降序排列
   *
   * @param isAsc true 升序， false 降序
   * @param arr
   */
  public  static  void   sort(int arr[], boolean isAsc) {
    if(isAsc){
      for (int i = 0; i <arr.length; i++) {
        for (int j = 0; j <arr.length-1-i; j++) {
            if(arr[j]>arr[j+1]){
              swap(arr,j);
            }
        }
      }
    }else {
      for (int i = 0; i < arr.length; i++) {
        for (int j = 0; j < arr.length - 1 - i; j++) {
          if (arr[j] < arr[j + 1]) {
            swap(arr, j);
          }
        }
      }
    }
  }

  /**
   * 修饰符     返回值的数据类型  方法名(参数列表){
   *
   *      return  值;
   * }
   *  void  表示方法无返回值
   *
   * @param
   * @param
   */

  public  static  String contant(int sx){
    return  ""+sx;  //  null(空)  ""(空串)
  }


  public  static   void   swap(int [] arr,int j){
    int  temp=arr[j];
    arr[j]=arr[j+1];
    arr[j+1]=temp;
  }




}
