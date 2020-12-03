package club.banyuan.demo;

import java.util.Map;
import java.util.function.Function;

/**
 * @author sanye
 * @version 1.0
 * @date 2020/12/3 3:18 下午
 */
public class LambdaDemo1 {

  /*1.不接受参数，直接返回1
      ()->1
   2.接受两个int类型的参数，返回这两个参数的和
      (int x,int y )-> x+y
   3.接受x,y两个参数，JVM根据上下文推断参数的类型，返回两个参数的和
      (x,y)->x+y
  4.接受一个字符串，打印该字符串，没有返回值
      (String name)->System.out.println(name)
  5.接受一个参数，JVM根据上下文推断参数的类型，打印该参数，没有返回值,只有一个参数可以省略圆括号
  name->System.out.prinln(name)
  6.接受两个String类型参数，分别输出，没有返回值
      (String name,String sex)->{ System.out.println(name);System.out.println(sex) }
  7.接受一个参数，返回它本身的2倍
  x->2*x

  */


  public static void main(String[] args) {

     UserDao userDao= new  UserDao(){
        @Override
        public Integer compare(Integer integer1, Integer integer2) {
            return  integer1-integer2;
        }
     };
     Integer compare = userDao.compare(23, 5);
     //lambda表达式
    UserDao  userDao1=(x,y) -> x-y;

    System.out.println(userDao1.compare(12, 6));



//    Calculator calculator = () -> System.out.println("我是武当传人...");
//    calculator.sum();

//    Calculator calculator=(i)->{
//      System.out.println("我是真的穷..."+i);
//    };
//   calculator.sum(45);

    Calculator calculator=i-> i*2;
    System.out.println(calculator.sum(3));


  }
}
@FunctionalInterface
interface  UserDao{

  Integer   compare(Integer integer1,Integer integer2);
  //int  delete();
}

@FunctionalInterface
interface  Calculator{

 // void   sum();

 // void  sum(Integer i);
    int   sum(Integer integer);
}

