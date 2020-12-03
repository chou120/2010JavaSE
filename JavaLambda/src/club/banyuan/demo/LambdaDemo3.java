package club.banyuan.demo;

import java.math.BigDecimal;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;


/**
 * @author sanye
 * @version 1.0
 * @date 2020/12/3 4:22 下午
 */
public class LambdaDemo3 {

  public static void main(String[] args) {

    /*Consumer<String> c1 = r -> System.out.printf(r);
    c1.accept("1");
    Consumer<String> c2 = System.out::printf;
    c2.accept("2");
*/
    int i = Integer.parseInt("2");

    Function<String, Integer> function = string -> Integer.parseInt(string);
    System.out.println(function.apply("32"));

//    final String s = get( MyStringOps::strReverse, "大保健");
//    System.out.println(s);

    MyStringOps myStringOps = new MyStringOps();

    String lambda_add_power_to_java = get(myStringOps::strReverse,
        "lambda add power to Java");
    System.out.println(lambda_add_power_to_java);

    Consumer<String> n1 = r -> new BigDecimal(r);
    n1.accept("1");
    Consumer<String> n2 = BigDecimal::new;
    n2.accept("2");

//   Supplier<Inner> supplier = Inner::new;
//     Inner r = supplier.get();
//     r.setAge(12);
//     r.setName("张三");
//
//

    BiFunction<String, Integer, Inner> supplier = Inner::new;
    Inner inner = supplier.apply("张", 12);

    Consumer<Inner> consumer = System.out::println;
    consumer.accept(inner);





  }

  //构造函数  使用lambda来创建对象
  private static class Inner {

    private String name;
    private Integer age;

    public Inner() {
      System.out.println("无参构造...");
    }

    public Inner(String name, Integer age) {
      this.name = name;
      this.age = age;
      System.out.println("有参构造.....");
    }

    public String getName() {
      return name;
    }

    public void setName(String name) {
      this.name = name;
    }

    public Integer getAge() {
      return age;
    }

    public void setAge(Integer age) {
      this.age = age;
    }

    @Override
    public String toString() {
      return "Inner{" +
          "name='" + name + '\'' +
          ", age=" + age +
          '}';
    }
  }


  public static String get(Operation operation, String string) {
    return operation.func(string);
  }

//  win7  32位   jdk   32bit   jdk  -64bit
//  win7      64位
//
//      win10


}

@FunctionalInterface
interface Operation {

  String func(String n);
}


class MyStringOps {

  //静态方法： 反转字符串
  /*public static String strReverse(String str) {
    String result = "";
    for (int i = str.length() - 1; i >= 0; i--) {
      result += str.charAt(i);
    }
    return result;
  }*/

  //实例方法引用
  public String strReverse(String str) {
    String result = "";
    for (int i = str.length() - 1; i >= 0; i--) {
      result += str.charAt(i);
    }
    return result;
  }


}

class A {

  public void method(Integer integer) {
    System.out.println("父类" + integer);
  }

}

class B extends A {

  public void show() {
    //Consumer<Integer> method = this::method;
    // method.accept(12);

    Consumer<Integer> in = (integer) -> this.method(integer);
    in.accept(12);

  }

  public void method(Integer integer) {
    System.out.println("子类" + integer);
  }

  public static void main(String[] args) {
    new B().show();
  }

}


