import java.util.List;

public class AddToListThread extends Thread {

  private List<String> list;

  public AddToListThread(List<String> list) {
    this.list = list;
  }

  @Override
  public void run() {
    try {
      Thread.sleep(50);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    for (int i = 0; i < 10; i++) {
      addToList(i);
    }
  }

  private void addToList(int i) {
    list.add(getName() + ":" + i);
  }
}
