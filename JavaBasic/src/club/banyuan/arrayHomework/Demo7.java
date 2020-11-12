package club.banyuan.arrayHomework;

/**
 * @author sanye
 * @version 1.0
 * @date 2020/11/12 1:34 下午
 */
public class Demo7 {

  /**
   * 满分是120分。2.0级以上为及格
   * 每增加5分，等级就会上升。注意4.3级并不存在。
   * 下表显示了分数与成绩之间的映射关系:
   *
   *
   * grade	  points
   * 1.0	    0 - 49.5
   * 1.3	    50 - 59.5
   *
   *
   *
   * 1.7	    60 - 64.5
   *
   * 从第3行开始就是60 - 64.5  一共有12行 可以循环12次
   *
   * 把第一行第二行和最后一行单独拎出来,而且是每5分提升一个等级
   *
   * 按照正常情况下到第三行应该是60+2*5 - 60+2*5+4.5
   *
   * 第四行应该是     60+3*5 -60+3*5+4.5
   * 以此类推
   * 但是    每五分一个等级是从60开始的
   *
   * 所以相当于
   * 60+0*5 - 60+0*5+4.5           3  60 -64.5  4  65-69.5
   * 综上所述 我们可以得一个结论
   *
   * 60+(i-2)*5+" - "+60+(i-2)*5+4.5
   *
   * 直到倒数第二行都会满足上述结构
   *
   * 然后我们开始去写等级代码:
   * 给一个默认等级
   * double grade=1.0;
   *1.0	    0 - 49.5   1
   *1.3	    50 - 59.5  2
   *
   * 1.7	    60 - 64.5 3
   * 2.0	    65 - 69.5 4
   * 2.3	    70 - 74.5 5
   * 2.7	    75 - 79.5 6
   * 3.0	    80 - 84.5
   * 3.3	    85 - 89.5
   * 3.7	    90 - 94.5
   * 4.0	    95 - 99.5
   * 4.7	    100 - 104.5
   *
   *
   *
   * 5.0	    105 - 120
   */

  public static void main(String[] args) {

   // System.out.printf("%.2f",0.1-0.09);  //保留两位小数
    printGradeTable();
  }
  public static void printGradeTable(){
    double grade=1.0;

    for (int i = 0; i <12; i++) {
              if(i==0){
                System.out.printf("%.1f\t0 ~ 49.5\n",grade);
              }else if(i==1){
                System.out.printf("%.1f\t50 ~ 59.5\n",grade);

              }else if(i==11){
                //当i==11的时候  是循环结束的一个临界点
                grade= getGrade(60+(i-2)*5);
                System.out.printf("%.1f\t105 ~ 120\n",grade);
              }else {
                //当i==2的是已经走到这里
                grade= getGrade(60+(i-2)*5);  //i==2的时候是一个临界点
                System.out.printf("%.1f\t"+(60+(i-2)*5)+" ~ "+(60+(i-2)*5+4.5)+"\n",grade);
              }

         grade= getGrade(60+(i-2)*5);

    }
  }

 public static double getGrade(double point){

    if(point>=0&&point<50){
      return 1.0;
    }
    if(point>=50&&point<60){
      return 1.3;
    }
    if(point>=105&&point<=120){
      return 5.0;
    }

    int  temp=(int) (point-60)/5;  //0   1

   /**
    *     1.7	    60 - 64.5
    *    * 2.0	    65 - 69.5
    *    * 2.3	    70 - 74.5
    *    * 2.7	    75 - 79.5
    *    * 3.0	    80 - 84.5
    *    * 3.3	    85 - 89.5
    *    * 3.7	    90 - 94.5
    *    * 4.0	    95 - 99.5
    *    * 4.7	    100 - 104.5
    */
    switch (temp){
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
}
