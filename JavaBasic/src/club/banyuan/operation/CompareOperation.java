package club.banyuan.operation;

/**
 * @author sanye
 * @version 1.0
 * @date 2020/11/10 10:56 上午
 */
public class CompareOperation {

  /**
   * 比较运算符 >,>=,<,<=,==,!=
   * <p>
   * 逻辑运算符
   * &，与  左边表达式不管是否成立 左边一定做判断
   * &&，短路与   左边不成立则右边不在执行  整个表达式都不成立
   *
   * |， 或    左边表达式不管是否成立依然继续判断右边表达式
   * ||，短路或 左边如果成立 则不在继续判断右边表达式  否则继续判断
   *
   * ！ 非   对整个结果进行取反
   * ^  异或
   */

  public static void main(String[] args) {
    int num1 = 12;
    int num2 = 45;

    System.out.println(num1 > num2);  //false
    System.out.println(num1 >= num2); //false
    System.out.println(num1 < num2); // true
    System.out.println(num1 <= num2); // true
    System.out.println(num1 == num2); //false
    System.out.println('a' == 97); // true

    System.out.println(">>>>>>>>逻辑运算符>>>>>>>>>>");
    //false & false
    System.out.println(num1 > num2 && num1 > num1 + num2);
    //true  & false
    System.out.println(num1 < num2 && num1 > num1 + num2);
    //false  & true
    System.out.println(num1 > num2 && num1 < num1 + num2);
    //true & true
    System.out.println(num1 < num2 && num1 < num1 + num2);

    //false & true
//    System.out.println(num1++ > 16 & ++ num1 > 10);
//    System.out.println("num1="+num1);
    //false  & true
//    System.out.println(num1++ > 16 && ++num1 > 10);
//    System.out.println("num1=" + num1);


    //true  | false
//    System.out.println(num1++ < 16 | ++num1 < 10);
//    System.out.println("num1=" + num1);

    //true  || false   ---->  true
  //   System.out.println(num1++ < 16 || ++num1 < 10);
  //   System.out.println("num1=" + num1);
    //相同为false  不同为true
    System.out.println(num1++ > 16 ^ num2 < 14);



  }
}
