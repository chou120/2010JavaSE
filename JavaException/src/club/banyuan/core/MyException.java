package club.banyuan.core;

/**
 * @author sanye
 * @version 1.0
 * @date 2020/11/30 2:03 下午
 */
public class MyException {

  /**
   *
   */
  public static void main(String[] args) {
//
//    int[] ints = new int[999999999];
//    System.out.println(ints[3]);

//**1）数组下标越界异常**   Java.lang.ArrayIndexOutOfBoundsException: Index 3 out of bounds for length 2
//
//**2）空指针异常**
//
//**3）算数异常 除数为0**  java.lang.ArithmeticException: / by zero
//
//**4）类型转换异常**
  /*  class java.lang.Object cannot be cast to class java.lang.Integer (java.lang.Object and java.lang.Integer are in module java.base of loader 'bootstrap')
    at club.banyuan.core.MyException.main(MyException.java:34)*/

    String []  str={"as","asdw"};
    str=null; // java.lang.NullPointerException
   // System.out.println(str[3]);

  //System.out.println(1/0); //java.lang.ArithmeticException: / by zero

    Object o = new Object();
    Integer integer = (Integer)o;
    System.out.println(integer);  //ERROR


  }
}
