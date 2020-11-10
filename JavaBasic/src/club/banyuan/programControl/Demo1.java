package club.banyuan.programControl;

import java.util.Scanner;

/**
 * @author sanye
 * @version 1.0
 * @date 2020/11/10 2:55 下午
 */
public class Demo1 {

  /**
   * 选择控制: if(condition){ 代码块; }
   * <p>
   * if(condition){ 代码块1; }else{ 代码块1; }
   * <p>
   * <p>
   * if(condition1){ 代码块1; }else if(condition2){ 代码块2; }else if(condition3){ 代码块3; .... }else{
   * <p>
   * }
   */

  public static void main(String[] args) {

    int a = 12;
    int b = 13;
//      if(a<b){
//        System.out.println("a>b");
//      }

//    if (a > b) {
//      System.out.println("a>b");
//    } else {
//      System.out.println("a<b");
//    }
//    if(a>10){
//      System.out.println("a>10");
//    }else if(a<10){
//      System.out.println("a<10");
//    }else{
//      System.out.println("a=10");
//    }

   // System.out.println("正在执行...");

    //求在座的各位的年龄大小
    //通过显示台手动输入数据
    Scanner scanner = new Scanner(System.in);
    System.out.println("请输入年龄:");
    int age=scanner.nextInt(); //获取控制台输入的数据 （得到int类型数据）
//    if(age>15 && age<=25){
//      System.out.println("青年");
//    }else if(age>25 && age<=35){
//      System.out.println("中青年");
//    }else if(age>35 && age<=45){
//      System.out.println("中年");
//    }else if(age>45 && age<=55){
//      System.out.println("中老年");
//    }else{
//      System.out.println("熊人...");
//    }
//
//    int num=5;
//    if(num++>13){
//      System.out.println("num="+num);
//    }else if(num++<7){
//      System.out.println("num="+num);
//    }else {
//      System.out.println("num="+num);
//    }

    /**
     * 一年有12个月    11 12 1 为冬季   2 3 4 春季 5 6 7 夏季 8 9 10 秋季
     * 请任意输入一个月份  判断其月份是在哪个季节
     * 注意: 有可能你输入的数据过大 或者 太小 或者不合法(-1)
     */








  }

}
