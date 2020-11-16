package club.banyuan.arrayPra;

import java.util.Arrays;

/**
 * @author sanye
 * @version 1.0
 * @date 2020/11/16 1:33 下午
 */
public class Demo1 {

  public static void main(String[] args) {

    double[][] dou = {{89.9, 98.9, 78.8, 77.5, 89},
        {90.9, 8.9, 78.8, 67.5, 79}, {80.9, 91.9, 78, 77, 89}};
    double[] sum = getSum(dou);
    System.out.println(Arrays.toString(sum));

    double[] avg = avg(dou);
    System.out.println(Arrays.toString(avg));

    String s = avgA(dou);
    System.out.println(s);


    String s1 = avgB(sum, dou[0].length);
    System.out.println("》》》》"+s1);

  }

//  public static String getSumB(double[][] arr) {
//    double[] doubles = new double[arr.length];  //每个班级的总分和的数组
//    double sum = 0;
//    for (int i = 0; i < arr.length; i++) {
//      for (int j = 0; j < arr[i].length; j++) {
//        sum = sum + arr[i][j];
//      }
//      doubles[i] = sum; //注意
//      //System.out.println("第"+(i+1)+"班级的总分和:"+sum);
//      sum = 0;
//    }
//    return "第一个总分为:xxx";
//  }



  public static double[] getSum(double[][] arr) {
    double[] doubles = new double[arr.length];  //每个班级的总分和的数组
    double sum = 0;
    for (int i = 0; i < arr.length; i++) {
      for (int j = 0; j < arr[i].length; j++) {
        sum = sum + arr[i][j];
      }
      doubles[i] = sum; //注意
      //System.out.println("第"+(i+1)+"班级的总分和:"+sum);
      sum = 0;
    }
    return doubles;
  }

  //求每个班级的平均分
  public static double[] avg(double[][] arr) {  //对每个班级的总分求平均分
    double[] sum = getSum(arr);  //  3
    double key = 0;
    double[] avg = new double[arr[0].length];
    for (int i = 0; i < arr.length; i++) {
      key = sum[i] / arr.length;
      //System.out.println(key);
      avg[i] = key;
    }
    return avg;
  }

  //返回字符串
  public static String avgA(double[][] arr) {  //对每个班级的总分求平均分
    double[] sum = getSum(arr);  //  3
    double key = 0;
    String str = "";
    for (int i = 0; i < sum.length; i++) {
      key = sum[i] / arr[0].length;
      str = str + "第" + (i + 1) + "班级的平均分为:" + key + "\t";
    }
    return str;
  }

  public static String avgB(double[] arr, int length) {  //对每个班级的总分求平均分
    double key = 0;
    String str = "";
    for (int i = 0; i < arr.length; i++) {
      key = arr[i] / length;
      str = str + "第" + (i + 1) + "班级的平均分为:" + key + "\t";
    }
    return str;
  }


}
