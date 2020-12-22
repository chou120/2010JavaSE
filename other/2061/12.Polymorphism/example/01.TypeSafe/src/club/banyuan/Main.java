package club.banyuan;

import club.banyuan.animal.Elephant;
import club.banyuan.animal.Fridge;
import club.banyuan.animal.Lion;

public class Main {

  public static void main(String[] args) {
    // int a = "string";

    Elephant e = new Elephant();
    Fridge fridge = new Fridge();
    fridge.setStorage(e);

    fridge.setLion(new Lion());
  }
}
