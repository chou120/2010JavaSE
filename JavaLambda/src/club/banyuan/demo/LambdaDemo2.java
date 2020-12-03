package club.banyuan.demo;

import java.util.Arrays;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * @author sanye
 * @version 1.0
 * @date 2020/12/3 3:44 下午
 */
public class LambdaDemo2 {


  public static void main(String[] args) {
    //(参数) -> { }  参数一定要和函数式接口里面的方法里面的参数列表一致
    //参数类
    Function<String, String> function = str -> {
      String st = str.toUpperCase();
      return "半圆" + st;
    };
    final String apply = function.apply("banyuan");
    System.out.println(apply);

    final Consumer<String> tPublisher = (money) -> {

      System.out.println("今天花了" + money + "钱,彻底穷了");

    };
    tPublisher.accept("2130");

    Cal cal = (qian) -> {
      System.out.println("今天花了" + qian + "钱,彻底穷了");
    };

    Supplier<User> supplier = () -> new User("张三", 120000000.9);
    User user = supplier.get();
    System.out.println(user);

    String [] st={"da","asdawa","张三你个大保健","adwgvsdg","李四是钻石王老五"};
    Predicate<String>  predicate=string ->  string.length()>6 ;

    for (int i = 0; i <st.length; i++) {
       boolean flag = predicate.test(st[i]);
       if(flag){
         st[i]=st[i]+"赚钱";
       }
    }

    System.out.println(Arrays.toString(st));


  }
  private static class User {

    private String name;
    private Double money;


    public User() {

    }

    public User(String name, Double money) {
      this.name = name;
      this.money = money;
    }

    @Override
    public String toString() {
      return "User{" +
          "name='" + name + '\'' +
          ", money=" + money +
          '}';
    }
  }


}


@FunctionalInterface
interface Cal {

  void max(Integer integer);
}

