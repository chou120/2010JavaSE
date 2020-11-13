package club.banyuan.check;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author sanye
 * @version 1.0
 * @date 2020/11/13 3:05 下午
 */
public class Demo {

  /**
   *
   */
  public static void main(String[] args) {
    int a = 1;
     /* if(a=1){   =  是赋值操作   =右边赋值给左边   == 判断左右两边是否相等
          代码;
        }
    */
//    Scanner scanner = new Scanner(System.in);
//    System.out.println("请输入一个数:");
//    int num = scanner.nextInt(); //9
//    if(num>0 && num< 20){
//      num=num+10;
//    }else if( num >50 && num<100){
//      num=num+60;
//    }else {
//      num = -num;  //-9
//    }
//    System.out.println(num);
//
//
//
    /*if (true) {  //布尔逻辑表达式
      System.out.println();
//      if (true)
//        System.out.println();
//      else
//        System.out.println();
    }else {
      System.out.println();
    }*/
    //getNumber(4);

//    if(x<9 && x>7){
//        代码;
//    }else if(){
//
//    }else{
//
//    }

    //请输入一个用户名  和 密码  判断是否满足条件
    // 如果满足条件条件 则调用对数组的所有信息的显示
    //如果不满足条件 则调用对数组的添加

//     boolean flag = checkNamePwd("张三", 133456);
//     String[] strings = {"张", "里", "哈哈是", "阿萨德"};
//    function(strings,flag);

      /*
      1  2  4   5  7  6 5 7   3
      for(1;2;3){
           for(4;5;6){
              7;
           }
      }
      */
    int i = 0;
    for (; i < 23; i++) {  //什么时候使用for   确定需要循环的次数
      //System.out.println("哈哈哈");
    }
    System.out.println(i);

    int num=12;
    while(true){
      if(num<4){
        break;
      }
      num--;
    }
    System.out.println(num+"sadas");

    /**
     * 对某个数据需要先执行代码 再进行判断   do{  }while();
     */

  }






  public static boolean checkNamePwd(String name, int pwd) {
    if (name == "张三" && pwd == 123456) {
      return true;
    }
    return false;
  }

  //对数组的操作
  public static void function(String[] str, boolean flag) {

    if (flag) {
      for (int i = 0; i < str.length; i++) {
        System.out.print(str[i] + "\t");
      }
    } else {
      //对数组做添加数据的操作
      Scanner scanner = new Scanner(System.in);
      System.out.println("请输入要添加的数据:");
      String string = scanner.next();
      System.out.println("请输入要添加的位置:");
      int index = scanner.nextInt();
      String[] strings = addArray(str, index, string);  //得到的新数组
      System.out.println(Arrays.toString(strings));
    }
  }

  /**
   * @param strings
   * @param index   下标
   * @param string
   */
  public static String[] addArray(String[] strings, int index, String string) {
    String[] newStr = new String[strings.length + 1];
    //  1 2 3 4 5 6 " "
    if (index < 0 || index > newStr.length) {
      System.err.println("插入位置不合法");
      return null; //表示方法已经结束
    }
    //如果插入的数组中间的位置
    for (int i = 0; i < index; i++) {
      newStr[i] = strings[i];
    }
    //  1234 56
    for (int i = index + 1; i < newStr.length; i++) {
      newStr[i] = strings[i - 1];  //旧的数组 要 减一
    }
    newStr[index] = string;
    //strings=newStr;//把新数组地址给旧数组
    //TODO 求证
    return newStr;
  }


  public static int getNumber(int num) {
    switch (num) {   // 整形  字符串   字符  枚举（jdk1.5）
      case 1:
        String info = getInfo();

        break;
      case 2:
        break;  //没有结束方法的作用
      case 3:
        System.out.println("3");
        // break;
      case 4:
//        System.out.println("4");
//        return 21;
      case 5:

      default:
        break;
    }
    System.out.println("代码执行否...");
    return 0;
  }

  public static String getInfo() {
    return "";
  }


}
