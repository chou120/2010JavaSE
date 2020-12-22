package club.banyuan.draw;

public class Lot {

  private String name;
  private int rate;

  public Lot(String name, int rate) {
    this.name = name;
    this.rate = rate;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getRate() {
    return rate;
  }

  public void setRate(int rate) {
    this.rate = rate;
  }
}
