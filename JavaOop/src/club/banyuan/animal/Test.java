package club.banyuan.animal;

import java.util.Scanner;

/**
 * @author sanye
 * @version 1.0
 * @date 2020/11/17 2:53 下午
 */
public class Test {


  public static void main(String[] args) {
    Scanner scanner=new  Scanner(System.in);
    Dog   dog=new Dog();

    System.out.println(dog.type+"--"+dog.age+"-"+dog.color);
    /**
     * 在不同包里面的   只有public 权限所修饰的成员可以被访问
     * 在同一个包下面   除了私有化的成员其他的(public  默认的  protected)都可以被访问
     *
     * 在同一个包下面的不同子类里面
     * 在不同包下面的子类里面
     *
     */
    dog.eat();
    dog.bark();
    dog.killHome();


  }


}
