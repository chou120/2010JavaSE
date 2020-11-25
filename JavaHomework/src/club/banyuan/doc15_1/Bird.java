package club.banyuan.doc15_1;

/**
 * @author sanye
 * @version 1.0
 * @date 2020/11/25 1:38 下午
 */
public class Bird {
  private  String  wings;
  private  String  legs;

  public Bird() {

  }

  public Bird(String wings, String legs) {
    this.wings = wings;
    this.legs = legs;
  }

  public String getWings() {
    return wings;
  }

  public void setWings(String wings) {
    this.wings = wings;
  }

  public String getLegs() {
    return legs;
  }

  public void setLegs(String legs) {
    this.legs = legs;
  }

  @Override
  public String toString() {
    return "Bird{" +
        "wings='" + wings + '\'' +
        ", legs='" + legs + '\'' +
        '}';
  }
}
