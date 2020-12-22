public class Fridge {

  int heightInCM;
  Elephant storage;

  /**
   * 实例方法
   * 对象就是实例
   */
  void printFridgeInfo() {
    System.out.printf("%d厘米高的冰箱中，保存了一个%d厘米高的大象\n", heightInCM, storage.heightInCM);
  }
}
