package club.banyuan.simulation;

public class ElephantDemo {

  public static void main(String[] args) {
    Fridge fridge = new Fridge(new Gate());

    Elephant elephant = new Elephant(300);
    // while (true) {
    //   try {
    //     fridge.openGate();
    //     break;
    //   } catch (GateBrokenException e) {
    //     System.out.println(e.getMessage());
    //   }
    // }

    try {
      fridge.openGate();
      fridge.setElephant(elephant);
      fridge.closeGate();
    } catch (GateBrokenException e) {
      System.out.println("冰箱出问题了");
      if (!fridge.isGateOpen()) {
        System.out.println("装大象失败");
      }
    }
    // fridge.setElephant(new Elephant(400));
  }
}
