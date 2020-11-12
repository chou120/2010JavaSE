package club.banyuan.arrayHomework;

/**
 * @author sanye
 * @version 1.0
 * @date 2020/11/12 9:45 上午
 */
public class Demo4 {

  /**
   * 编写一个方法输入分钟时间，向控制台输出多少年，多少天
   *
   * @param minute
   */
  public static void convert(long minute) {  //3456789
    /**
     * 3456789 分钟
     * 3456789 分钟是6年210天
     */
    //  60*24*365  一年
    long year = minute / (60 * 24 * 365); //得到年
    long date = minute % (60 * 24 * 365) / (60 * 24);  //不满足一年的就是剩下的

    System.out.println(minute + "分钟是" + year + "年" + date + "天");
  }


  /*
      int multiply(int n1, int n2)
      编写一个方法不使用 * 完成两个数相乘
   */
  public static void main(String[] args) {

    convert(3456789);

    System.out.println(multiply(12, 4));
    System.out.println(multiply(-12, 4));
    System.out.println(multiply(12, -4));

  }

  public static int multiply(int n1, int n2) {
    int mul = 0; //n1*n2
    //通过n1或者n2是否大小于0 判断结果是否是负数  flag=true  结果一定是负数
    boolean flag = (n1 > 0 && n2 < 0) || (n1 < 0 && n2 > 0);
    if (n2 < 0) {
      n2 = -n2;
    }
    if (n1 < 0) {
      n1 = -n1;
    }
    for (int i = 1; i <= n2; i++) {
      mul = mul + n1;
    }
    if (flag) {
      mul = -mul;
    }
    return mul;
  }
}
