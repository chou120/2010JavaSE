package club.banyuan.animal;

import javax.print.attribute.standard.NumberOfInterveningJobs;

public class Main {

  public static void main(String[] args) {
    Object o = new Animal();
    o = "12345";
    o = 1234;
    o = new Lion();

    Animal animal = new Animal();
    animal = new Lion();

    o = animal;

    Elephant elephant = new Elephant();
    elephant.elephantMethod();

    animal = elephant;
    // animal.elephantMethod();

    Elephant e = (Elephant) animal;
    e.elephantMethod();
    // animal.elephantMethod();

    // Lion lion = (Lion) animal;

    System.out.println(animal instanceof Elephant);
    System.out.println(e instanceof Elephant);
    System.out.println(e instanceof Object);
    System.out.println(o instanceof Lion);
    // System.out.println(e instanceof Lion);

    System.out.println(null instanceof Object);

    Animal a1 = null;
    if (a1 instanceof Elephant) {
      Elephant e2 = (Elephant) a1;
      System.out.println(e2);
      System.out.println("转换成功");
    } else {
      System.out.println("没有转换");
    }
  }
}
