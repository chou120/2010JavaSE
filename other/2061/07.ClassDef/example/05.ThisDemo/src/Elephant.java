public class Elephant {

  private int heightInCM;
  private String type;

  public Elephant() {
    // heightInCM = 300;
    // 使用this调用类中另一个构造方法
    // 调用的语句，必须是构造方法中的第一句话
    this(300);
    // this(200, "123");
    // 禁止构造方法自己调用自己，禁止构造方法相互引用产生死循环
    // this();
  }

  public Elephant(int heightInCM, String type) {
    this.heightInCM = heightInCM;
    this.type = type;
  }

  public int getHeightInCM() {
    return heightInCM;
  }

  public void setHeightInCM(int heightInCM) {
    this.heightInCM = heightInCM;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public Elephant(int heightInCM) {
    this.heightInCM = heightInCM;
  }

  public static void main(String[] args) {
    Elephant e = new Elephant();
  }
}
