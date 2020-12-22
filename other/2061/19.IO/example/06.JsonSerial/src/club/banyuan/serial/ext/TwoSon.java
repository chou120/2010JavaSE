package club.banyuan.serial.ext;

public class TwoSon extends Father {

  private String twoSonField;

  public String getTwoSonField() {
    return twoSonField;
  }

  public void setTwoSonField(String twoSonField) {
    this.twoSonField = twoSonField;
  }

  @Override
  public String toString() {
    return "TwoSon{" +
        "twoSonField='" + twoSonField + '\'' +
        '}';
  }
}
