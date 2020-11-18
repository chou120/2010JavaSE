package ques;

public class Fridge {

  private int heightInCM;
  private Elephant elephant;
  private Lion lion;


  //TODO 完成 移除方法
  Elephant remove(){
  //TODO
    return null;

  }

  public void store(Lion lion){
    //TODO
  }

  void printFridgeInfo() {
    if(elephant == null){
      System.out.println("冰箱没有装大象，是空的！");
      return;
    }
    // int heightInCM = 10;
    System.out.printf("%d厘米高的冰箱中，保存了一个%d厘米高的大象\n", heightInCM, elephant.getHeightInCM());

  }

  public int getHeightInCM() {
    return heightInCM;
  }

  public void setHeightInCM(int heightInCM) {
    this.heightInCM = heightInCM;
  }

  public Elephant getElephant() {
    return elephant;
  }

  public void setElephant(Elephant elephant) {
    this.elephant = elephant;
  }

  public void store(Elephant elephant) {
    if(lion == null && this.elephant == null){
      this.elephant = elephant;
    }else {
      System.out.println("冰箱已经满了！");
    }
  }


}
