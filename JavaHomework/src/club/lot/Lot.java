package club.lot;

public class Lot {

  private String name;  //用来存放是 大吉还是大凶
  private int rate; //出现的次数   

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
