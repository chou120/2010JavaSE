package club.banyuan.machine;

import club.banyuan.animal.AisaElephant;
import club.banyuan.animal.Elephant;
import club.banyuan.animal.Lion;
import club.banyuan.animal.Tiger;

public class Main {

  public static void main(String[] args) {
    AnimalFridge fridge = new AnimalFridge();
    fridge.addAnimal(new Elephant());
    fridge.addAnimal(new Lion());
    fridge.addAnimal(new Tiger());
    fridge.addAnimal(new AisaElephant());

    fridge.callElephantMethod();
    // fridge.setAnimal(new Animal());
    // fridge.setAnimal(new Elephant());
  }
}
