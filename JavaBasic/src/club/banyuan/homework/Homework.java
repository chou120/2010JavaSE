package club.banyuan.homework;

import java.util.Arrays;

/**
 * @author sanye
 * @version 1.0
 * @date 2020/11/11 8:26 下午
 */
public class Homework {

  /**
   * 转换结果如下 123  => 123.0 B 15323 => 15.323 KB 15323000 => 15.323 MB 1532300001=>1.532300001 GB
   */

  static String formateByte(long bytes) {
    String str = "";

    if (bytes < 1000) {
      str = str + bytes + "B";
    } else if (bytes < 1000000) {
      str = str + bytes / 1000.0 + "KB";
    } else if (bytes < 1000000000) {
      str = str + bytes / 1000000.0 + "MB";
    } else if (bytes < 1000000000000L) {
      str = str + bytes / 1000000000.0 + "GB";
    }
    return str;
  }


  public static void main(String[] args) {
    //System.out.println(formateByte(1532300001));
    printGradeTable();
    //System.out.println(Arrays.toString(filterArray(new int[] {1, 3, 3, 1, -3, -9, 12, 33})));
  }
  static void printGradeTable() {
    double grade = 1.0;
    for (int i = 0; i < 12; i++) {
      if (i == 0) {
        System.out.printf("%.1f\t0 - 49.5\n", grade);
      } else if (i == 1) {
        System.out.printf("%.1f\t50 - 59.5\n", grade);
      } else if (i == 11) {
        grade = getGrade(60 + (i - 2) * 5);
        System.out.printf("%.1f\t105 - 120\n", grade);
      } else {
        grade = getGrade(60 + (i - 2) * 5);
        System.out
            .printf("%.1f\t" + (60 + (i - 2) * 5) + " - " + (60 + (i - 2) * 5 + 4.5) + "\n", grade);
      }
    }
  }
  static double getGrade(double point) {
    if (point <= 49.5) {
      return 1.0;
    } else if (point <= 59.5 && point >= 50) {
      return 1.3;
    }
    if (point >= 105) {
      return 5.0;
    }
    int step = (int) ((point - 60) / 5);
    switch (step) {
      case 0:
        return 1.7;
      case 1:
        return 2.0;
      case 2:
        return 2.3;
      case 3:
        return 2.7;
      case 4:
        return 3.0;
      case 5:
        return 3.3;
      case 6:
        return 3.7;
      case 7:
        return 4.0;
      case 8:
        return 4.7;
    }
    return 0.0;
  }


  //它返回考试中达到的分数，并打印出从0到120的所有分数的分数(步骤为0.5)。
  static boolean isPass(double point) {
    return false;
  }


  /**
   * 数组去重功能
   *
   * @param arr
   */
  static int [] filterArray(int[] arr) {

    int t=0;

    int[] xinArr=new int[arr.length];
    for(int i=0;i<arr.length;i++){
      //声明标记，是否重复
      boolean isRepeat = true;
      for(int j=i+1;j<arr.length;j++){
        //如果有重复元素，将标记置为false
        if(arr[i]==arr[j]){
          isRepeat = false;
          break;
        }
      }
      //标记为true表示没有重复元素
      if(isRepeat){
        xinArr[t] = arr[i];
        t++;
      }
    }
    //去重后数组
    int[] newArr = new int[t];
    System.arraycopy(xinArr, 0, newArr, 0, t);
    return newArr;
  }

}
