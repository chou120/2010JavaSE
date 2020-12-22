package club.bayuan.philosopher;

public class Chopstick {

  private String id;
  private boolean isTaken;

  public Chopstick(String id) {
    this.id = id;
  }

  public void take(String name) {
    isTaken = true;
    System.out.println("筷子" + id + "被" + name + "拿起！");
  }

  public void put(String name) {
    isTaken = false;
    System.out.println("筷子" + id + "被" + name + "放下！");
  }

}
