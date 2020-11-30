package club.banyuan.core3;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * @author sanye
 * @version 1.0
 * @date 2020/11/30 3:08 下午
 */
public class MyException {

  public static void main(String[] args) {
//    Scanner scanner = new Scanner(System.in);
//    System.out.println("请输入第一个数：");
//    int num1 = scanner.nextInt();
//    System.out.println("请输入第二个数：");
//    int num2 = scanner.nextInt();
//    int age = getNumber(num1, num2);
//
//    System.out.println("如果输入的num2=0,那么age最终得到数据为:" + age);


//    try {
//      changeDateFormat("19900101");  //非运行异常
//    }catch (ParseException  e){
//      e.printStackTrace();
//    }
//    try {
//      changeDateFormat("19900101");
//    } catch (ParseException e) {
//      e.printStackTrace();
//    }
//    System.out.println("后面代码执行不？");
  }

  public static int getNumber(int num1, int num2) {
    int age = 12;
    try {
      //可能出现异常的代码块的位置
      int x = num1 / num2;  //num2=0;
      age = 25;
      return age;
    } catch (Exception e) {
      e.printStackTrace();
      age = 34;
      return age;//表示方法结束
    } finally {  //不管是否出现异常都回去执行
      age = 23;
      return age;
    }
  }

  //另一种处理异常的方式 throws(结合非运行时异常)

  /**
   * throws  throws关键字是跟在方法名之后的，一个throws后面可以跟至少一个的异常类型，
   * 它的作用是：当前方法可能会抛出异常，但是不知道如何处理该异常，
   * 就将该异常交由调用这个方法的的上一级使用者处理，如果main方法也不知道如何处理这个异常的时候，
   * 就会交由JVM来处理这个异常，JVM的做法是：打印异常的跟踪栈消息，并终止程序
   *
   * Exception in thread "main" java.text.ParseException: Unparseable date: "19900101"
   *
   * @param string
   * @return
   * @throws ParseException
   */

  public static Date changeDateFormat(String string) throws ParseException {  //19900101  1990-01-01

    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    Date date = null;
    try {
      date=simpleDateFormat.parse(string);  //
    } catch (ParseException e) {
      System.err.println("转换的字符串格式有问题...");
    }
   // date=simpleDateFormat.parse(string);
    return date;
  }


}
