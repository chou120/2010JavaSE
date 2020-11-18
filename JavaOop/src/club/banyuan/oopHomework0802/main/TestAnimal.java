package club.banyuan.oopHomework0802.main;

import club.banyuan.oopHomework0802.cat.Cat;
import club.banyuan.oopHomework0802.dog.Dog;

/**
 * @author sanye
 * @version 1.0
 * @date 2020/11/18 9:47 上午
 */
public class TestAnimal {

  public static void main(String[] args) {
    Dog dog = new Dog();
    dog.setType("哈斯奇");
    dog.setIQ(10);

    Dog dog1 = new Dog();
    dog1.setType("单身狗");
    dog1.setIQ(99);

    Cat cat = new Cat();
    cat.setColor("黑色");
    cat.setType("英短");

    Cat cat1 = new Cat();
    cat1.setType("波斯猫");
    cat1.setColor("咖啡色");

    dog.printInfo();
    dog1.printInfo();

    dog.playWith(cat);
    dog1.playWith(cat1);

    cat.printInfo();
    cat1.printInfo();

    cat.playWith(dog1);
    cat1.playWith(dog);





  }
}
