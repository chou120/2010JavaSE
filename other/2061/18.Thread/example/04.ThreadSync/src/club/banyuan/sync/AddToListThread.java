package club.banyuan.sync;

import java.util.List;

public class AddToListThread extends Thread {

  private List<String> list;

  public AddToListThread(String name, List<String> list) {
    super(name);
    this.list = list;
  }

  @Override
  public void run() {
    try {
      Thread.sleep(50);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    // for (int i = 0; i < 10; i++) {
    //   synchronized (this) {
    //     addToList(i);
    //   }
    // }

    for (int i = 0; i < 10; i++) {
      addToList(i);
    }
  }

  private void addToList(int i) {
    list.add(getName() + ":" + i);
  }

  private void addToListSync(int i) {
    synchronized (list) {
      list.add(getName() + ":" + i);
    }
  }

  // 等价于synchronized方法
  private void addToListThis(int i) {
    synchronized (this) {
      list.add(getName() + ":" + i);
    }
  }

  private synchronized void addToListRefine(int i) {
    list.add(getName() + ":" + i);
  }
}
