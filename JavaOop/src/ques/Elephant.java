package ques;

/**
 * 定义类，类是用来描述对象模板的，一个对象中应该包含哪些属性
 */
public class Elephant {

  // field 成员变量、属性、字段
  private int heightInCM = 200;

  // 构造方法 没有返回值
  // 方法名和类名一致
  Elephant(int heightInCM) {
    this.heightInCM = heightInCM;
  }

  public Elephant() {
  }

  public int getHeightInCM() {
    return heightInCM;
  }

  public void setHeightInCM(int heightInCM) {

    if (heightInCM < 0) {
      System.err.println("高度不合法，给与一个默认高度200");
      this.heightInCM = 200;
      return;
    }
    // this指代了调用这个实例方法的对象，当局部变量名和实例成员变量名字冲突的时候。
    // 使用this区分局部变量和实例成员。this.成员变量名
    this.heightInCM = heightInCM;
  }

  public static void main(String[] args) {
    Elephant elephant = new Elephant();
    elephant.heightInCM = -5;
    elephant.setHeightInCM(-5);
  }
}
