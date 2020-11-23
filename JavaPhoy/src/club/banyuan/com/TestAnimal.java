package club.banyuan.com;

/**
 * @author sanye
 * @version 1.0
 * @date 2020/11/23 1:53 下午
 */
public class TestAnimal {

  /**
   * 1.多态:多种形态, 在不同时刻的不同状态
   * <p>
   * 多态前提:1.要有继承 2.发生方法重写 3.父类引用指向子类对象
   *
   * 2.
   * 成员变量
   * 成员方法
   * 静态方法
   *
   */


  public static void main(String[] args) {

//    Dog dog = new Dog();
//    dog.eat();
//
//    Cat cat = new Cat();
//    cat.eat();

    Animal animal=new Dog();  //  父类引用指向的是子类对象
//    Dog  dog=new  Dog();
//    dog.eat();

//    animal.eat();
//    animal=new Cat();
//    animal.eat();//猫
//
//
//    Tool.getCat(new  Cat());
//    Tool.getDog(new Dog());
//    Tool.getPig(new Pig());
//

    //使用animal的方法
    Tool.getAnimal(animal); //dog









  }
}
