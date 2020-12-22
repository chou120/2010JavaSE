public class Main {

  static Elephant createElephant(int heightInCM) {
    System.out.printf("创建一个%d厘米高的大象！\n", heightInCM);
    // 通过new 创建类的对象
    // new 对象，相当于创建对象，也叫做类的实例化
    // 创建出来的对象也叫做实例
    Elephant elephant = new Elephant(heightInCM);
    elephant.setHeightInCM(heightInCM);
    return elephant;
  }

  static void printFridgeInfo(Fridge fridge) {
    System.out.printf("%d厘米高的冰箱中，保存了一个%d厘米高的大象\n", fridge.getHeightInCM(),
        fridge.getElephant().getHeightInCM());
  }

  static Fridge createFridge(int heightInCM) {
    System.out.printf("创建一个%d厘米高的冰箱！\n", heightInCM);
    // 通过new 创建类的对象
    Fridge fridge = new Fridge();
    fridge.setHeightInCM(heightInCM);
    return fridge;
  }
  static Lion createLion(int heightInCM){
    System.out.printf("创建一个%d厘米高的狮子！\n",heightInCM);
    Lion lion =new Lion();
    lion.setHeightInCM(heightInCM);
    return lion;
  }

  public static void main(String[] args) {
    Lion l1 = createLion(300);
    Elephant e1 = createElephant(400);
    Elephant e2 = createElephant(350);

    Fridge f1 = createFridge(500);
    f1.store(e1);
    printFridgeInfo(f1);
    f1.printFridgeInfo();
    f1.remove();

    Fridge f2 = createFridge(550);
    f2.store(e2);
    f2.printFridgeInfo();
    f2.remove();

    Fridge f3 = createFridge(550);
    f3.store(l1);
    f3.printFridgeInfo();
    f3.remove();
  }
}
