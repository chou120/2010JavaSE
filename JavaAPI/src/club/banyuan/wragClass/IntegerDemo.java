package club.banyuan.wragClass;

import java.util.Scanner;

/**
 * @author sanye
 * @version 1.0
 * @date 2020/11/27 10:56 上午
 */
public class IntegerDemo {

  public static void main(String[] args) {
    /**
     *  int          byte     short   boolean     double  float  char           long
     *  Integer      Byte   Short    Boolean       Double Float  Character      Long
     *
     *  作用:
     *    用来将基本数据类型和各个其他数据类型之间的转换更方便
     */
    String str = "1234";
    int num = 123;

    int i = Integer.parseInt(str);
    Integer integer = Integer.valueOf(str);
    //int i1 = integer.intValue();  自动转换  自动拆箱

    System.out.println(num + integer);

    int  nex=123;
    Integer integer1 = new Integer(nex);  //自动装箱
    Integer  in=34;

    Integer  number=integer1+in;
    final int i1 = Integer.parseInt("34", 16);   //  34 为进制数  3*16+4*16^0
    System.out.println(i1);

    System.out.println(Character.isDigit('1'));  // 判断当前字符是否是数字
    // 请输入一行非数字字符串
    Scanner  scanner=new Scanner(System.in);
    System.out.println("请输入数据");
    String  strData=scanner.nextLine(); //

    for (int j = 0; j < strData.length(); j++) {
       char c = strData.charAt(j);
       if(Character.isDigit(c)){
         System.out.println("有数字...");
       }
    }

    final Boolean asdas =  Boolean.valueOf("true");
    System.out.println(asdas);

  }
}
