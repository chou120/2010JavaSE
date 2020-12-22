public class Fridge {

  private int heightInCM;
  private Elephant storage;

  /**
   * 实例方法
   * 对象就是实例
   */
  void printFridgeInfo() {
    // int heightInCM = 10;
    System.out.printf("%d厘米高的冰箱中，保存了一个%d厘米高的大象\n", heightInCM, storage.getHeightInCM());
  }

  public int getHeightInCM() {
    return heightInCM;
  }

  public void setHeightInCM(int heightInCM) {
    this.heightInCM = heightInCM;
  }

  public Elephant getStorage() {
    return storage;
  }

  public void setStorage(Elephant storage) {
    this.storage = storage;
  }
}
