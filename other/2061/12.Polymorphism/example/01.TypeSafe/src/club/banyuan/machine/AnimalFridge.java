package club.banyuan.machine;

import club.banyuan.animal.Animal;
import club.banyuan.animal.Elephant;

public class AnimalFridge {

  private Animal[] animals = new Animal[10];
  private int count;
  // private Lion lion;
  // private Tiger tiger;
  // private AisaElephant aisaElephant;


  public void addAnimal(Animal animal) {
    animals[count++] = animal;
    System.out.println("冰箱关了一个:" + animal.getType());
  }

  public void callElephantMethod() {
    for (int i = 0; i < count; i++) {
      if (animals[i] instanceof Elephant) {
        ((Elephant) animals[i]).elephantMethod();
      }
    }
  }

  // Elephant elephant;

  // public Elephant getElephant() {
  //   return elephant;
  // }
  //
  // public void setElephant(Elephant elephant) {
  //   this.elephant = elephant;
  // }

  // public Animal getAnimal() {
  //   return elephant;
  // }
  //
  // public void setAnimal(Animal animal) {
  //   this.animal = animal;
  // }


}
