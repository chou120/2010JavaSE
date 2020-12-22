package club.banyuan.serial.ext;

public class OneSon extends Father {

  private String oneSonField;

  public String getOneSonField() {
    return oneSonField;
  }

  public void setOneSonField(String oneSonField) {
    this.oneSonField = oneSonField;
  }

  @Override
  public String toString() {
    return "OneSon{" +
        "oneSonField='" + oneSonField + '\'' +
        '}';
  }
}
