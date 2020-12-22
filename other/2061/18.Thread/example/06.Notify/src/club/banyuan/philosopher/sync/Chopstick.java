package club.banyuan.philosopher.sync;

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

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public boolean isTaken() {
    return isTaken;
  }

  public void setTaken(boolean taken) {
    isTaken = taken;
  }
}
