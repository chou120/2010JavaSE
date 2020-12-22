package club.banyuan.elephant;

public class Main {

  static Elephant createElephant(int heightInCM) {
    System.out.printf("创建一个%d厘米高的大象！\n", heightInCM);
    // 通过new 创建类的对象
    // new 对象，相当于创建对象，也叫做类的实例化
    // 创建出来的对象也叫做实例
    // Elephant elephant = new Elephant(heightInCM);
    // elephant.setHeightInCM(heightInCM);
    // return elephant;
    return null;
  }

  static void printFridgeInfo(Fridge fridge) {
    System.out.printf("%d厘米高的冰箱中，保存了一个%d厘米高的大象\n", fridge.getHeightInCM(),
        fridge.getStorage().getHeightInCM());
  }

  static Fridge createFridge(int heightInCM) {
    System.out.printf("创建一个%d厘米高的冰箱！\n", heightInCM);
    // 通过new 创建类的对象
    Fridge fridge = new Fridge();
    fridge.setHeightInCM(heightInCM);
    return fridge;
  }

  public static void main(String[] args) {
    Elephant e1 = createElephant(400);
    Elephant e2 = createElephant(350);
    //
    // Elephant e1 = new Elephant();
    // e1.heightInCM = 400;
    //
    // Elephant e2 = new Elephant();
    // e2.heightInCM = 350;

    // Fridge f1 = new Fridge();
    // f1.heightInCM = 500;
    // f1.storage = e1;

    Fridge f1 = createFridge(500);
    f1.setStorage(e1);
    printFridgeInfo(f1);
    f1.printFridgeInfo();

    Fridge f2 = createFridge(550);
    f2.setStorage(e2);
    f2.printFridgeInfo();

    // Elephant e3 = new Elephant();
  }
}
