package club.banyuan.sync;

import java.util.Random;

public class SyncMethodThread extends Thread {

  private SyncMethod syncMethod;

  public SyncMethodThread(SyncMethod syncMethod) {
    this.syncMethod = syncMethod;
  }

  @Override
  public void run() {
    for (int i = 0; i < 10; i++) {
      if (new Random().nextBoolean()) {
        syncMethod.print(getName());
      } else {
        // syncMethod.printOther();
        SyncMethod.printStatic(getName());
      }
      // SyncMethod.printStatic(getName());
    }
  }

  public static void main(String[] args) {
    SyncMethod syncMethod = new SyncMethod();
    SyncMethodThread t1 = new SyncMethodThread(syncMethod);
    SyncMethodThread t2 = new SyncMethodThread(syncMethod);
    t1.start();
    t2.start();
  }
}
