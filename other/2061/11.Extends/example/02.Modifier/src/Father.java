
// public protected default(不写) private
//          类内部，同包类内部，子类内部，不同包类内部
//  public    ✔️      ✔️      ✔️        ✔
// protected ️ ✔️     ✔       ✔
//  default     ✔️    ✔
// private    ✔️
public class Father {

  private String fatherField = "fatherPrivateFiled";
  protected String protectedField = "protectedField";

  public String getFatherField() {
    return fatherField;
  }

  public void setFatherField(String fatherField) {
    this.fatherField = fatherField;
  }

  private void privateMethod() {
    System.out.println("私有方法");
  }

  void packageAccessMethod() {

  }
}
