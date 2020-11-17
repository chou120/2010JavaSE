package club.banyuan.testAnimal;

import java.util.Scanner;
import club.banyuan.animal.Dog;
/**
 * @author sanye
 * @version 1.0
 * @date 2020/11/17 2:53 下午
 */
public class Test {


  public static void main(String[] args) {
    Scanner scanner=new  Scanner(System.in);
    Dog   dog=new Dog();
    dog.eat();
    System.out.println(dog.type);
    /**
     * 在不同包里面的   只有public 权限所修饰的成员可以被访问
     */


  }


}
