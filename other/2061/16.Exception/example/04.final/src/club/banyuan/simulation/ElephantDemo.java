package club.banyuan.simulation;

public class ElephantDemo {

  public static void main(String[] args) {
    Fridge fridge = new Fridge(new Gate());

    Elephant elephant = new Elephant(300);

    try {
      fridge.openGate();
      fridge.setElephant(elephant);
      fridge.setElephant(elephant);
    } catch (GateBrokenException e) {
      System.out.println("冰箱出问题了");
      if (!fridge.isGateOpen()) {
        System.out.println("装大象失败");
      }
    } catch (FridgeFullException e) {
      System.out.println(e.getMessage());
    } finally {
      // finally 代码块中的代码一定会被执行，通常把需要关闭资源的代码放到这里面
      try {
        if (fridge.isGateOpen()) {
          fridge.closeGate();
        }
      } catch (GateBrokenException e) {
        e.printStackTrace();
      }
    }
    // fridge.setElephant(new Elephant(400));
    System.out.println(fridge.isGateOpen());
  }
}
