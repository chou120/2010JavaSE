public class Father {

  private String name;

  // final 强制要求子类不要重写被修饰的方法
  public final String getName() {
    return name;
  }

  public final void setName(String name) {
    this.name = name;
  }
}
