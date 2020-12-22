package club.banyuan.sync;

import java.util.Random;

public class SyncMethod {

  synchronized public void print(String name) {
    System.out.println(name + ":print begin");
    try {
      Thread.sleep(new Random().nextInt(1000));
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    System.out.println(name + ":print end");
  }

  public void printOther() {
    synchronized (this) {
      System.out.println("print other begin");
      try {
        Thread.sleep(new Random().nextInt(1000));
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      System.out.println("print other end");
    }

  }

  synchronized public static void printStatic(String name) {
    System.out.println(name + ":print static begin");
    try {
      Thread.sleep(new Random().nextInt(1000));
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    System.out.println(name + ":print static end");
  }

  public static void printStaticSyncClass(String name) {
    synchronized (SyncMethod.class) {
      System.out.println(name + ":print static begin");
      try {
        Thread.sleep(new Random().nextInt(1000));
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      System.out.println(name + ":print static end");
    }
  }


}
