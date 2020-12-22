package club.banyuan.simulation;

import java.util.Random;

public class Gate {

  private boolean isOpen;
  private static Random rand = new Random();

  public boolean isOpen() {
    return isOpen;
  }

  public void setOpen(boolean open) throws GateBrokenException {
    if (open) {
      if (rand.nextBoolean()) {
        throw new GateBrokenException("开门失败，门坏掉了");
      }
    }
    isOpen = open;
  }
}
