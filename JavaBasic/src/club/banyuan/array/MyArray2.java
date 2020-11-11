package club.banyuan.array;

import java.util.Scanner;

/**
 * @author sanye
 * @version 1.0
 * @date 2020/11/11 11:09 上午
 */
public class MyArray2 {

  public static void main(String[] args) {
    //对数组 进行增删改查操作
    String [] str=new  String[5];
    final Scanner scanner = new Scanner(System.in);
    for (int i = 0; i <str.length; i++) {
      str[i]=scanner.next();  //获取字符串(不包含空格)
    }

    for (int i = 0; i <str.length; i++) {
      System.out.print(str[i]+"\t");
    }

    //对数组指定位置添加数据 并且保证原有的几个数据不变
    //     1   2   3    4   5
      //   1   2   3    89  4  5
    // 涉及到 数组长度变化    从插入位置开始后面数据的位置都变化
    System.out.println("请输入插入数据的位置:");
    int  index=scanner.nextInt(); // index 表示的是数组的中的位置  位置-1=下标
    System.out.println("请输入要插入的数据:");
    String  st=scanner.next();

    if(index > str.length || index < 0){  //保证插入的数据要在数组内
      System.err.println("你输入的位置有误...");
    }
    String [] strCopy=new String[str.length+1];  //添加一个数据就扩容一个长度
    for (int i = 0; i < index; i++) { //4  index位置前面的数据
      strCopy[i]=str[i];
    }
    for (int i = index; i < strCopy.length; i++) { //index位置后面的数据
      strCopy[i]=str[i-1];
    }
    strCopy[index-1]=st; //index位置  也就是下标为 index-1 的
    str=strCopy;  //重新赋值给数组 str  是为了保证str数组原有的数据不变而且在原有的基础之上添加了新的数据
    System.out.println(">>>>>>>>>");
    for (int i = 0; i <str.length ; i++) {
      System.out.print(str[i]+"\t");
    }



  }

}
