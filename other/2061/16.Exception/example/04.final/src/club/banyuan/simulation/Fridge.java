package club.banyuan.simulation;

public class Fridge {

  private Elephant elephant;
  private Gate gate;

  public Fridge(Gate gate) {
    this.gate = gate;
  }

  public Elephant getElephant() {
    return elephant;
  }

  public void setElephant(Elephant elephant) {
    if (!gate.isOpen()) {
      throw new FridgeGateStateException("门没有开，不能装大象！");
    }
    if (this.elephant != null) {
      throw new FridgeFullException("已经有了一个大象:" + this.elephant.getHeightInCM());
    }
    this.elephant = elephant;
    System.out.println("把大象装到了冰箱中");
  }

  public void openGate() throws GateBrokenException {
    if (gate.isOpen()) {
      throw new FridgeGateStateException("已经打开了");
    }
    gate.setOpen(true);
  }

  public void closeGate() throws GateBrokenException {
    if (!gate.isOpen()) {
      throw new FridgeGateStateException("已经关闭了");
    }
    gate.setOpen(false);
  }

  public boolean isGateOpen() {
    return gate.isOpen();
  }
}
