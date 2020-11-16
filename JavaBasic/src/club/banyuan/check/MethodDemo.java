package club.banyuan.check;

import java.util.HashSet;

/**
 * @author sanye
 * @version 1.0
 * @date 2020/11/13 4:11 下午
 */
public class MethodDemo {

  /**
   * 局部变量:一般在方法内或者在方法上(（）括号里面)  在方法结束的时候才会消失
   * 全局变量:在类里面 方法外面   能被所有的方法调用  在整个程序结束的时候才会消失
   * @param args
   */

  static int number=12;

  public static void main(String[] args) {
    //getInfo(1);

    //什么时候可以使用方法   使用方法的背景 也就是前提
    // 一般情况下  出现相同功能的代码可以提取出公共的代码块的时候
    // 还有个就是如果你写的代码块使用效率很高 并且别人也在使用你写的代码块

  }



  public  static  String  print(int [] arr){

    return "";
  }



  public static void getInfo(int  number){ //局部变量和全局变量同时存在的时候 优先使用局部变量
    System.out.println(number);
    method(number); //
  }

  public  static void  method(int  number){
    System.out.println(number);
  }

  /**
   *
   */

  public  static  String  getStr(char  ch){
    int  st=ch+67;
    return  "你好"+st;
  }

  public  static  String  getStr(int  ch){
    int  st=ch+67;
    return  "你好"+st;
  }



}
