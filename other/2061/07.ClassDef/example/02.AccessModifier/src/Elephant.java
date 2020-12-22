/**
 * 定义类，类是用来描述对象模板的，一个对象中应该包含哪些属性
 */
public class Elephant {

  // field 成员变量、属性、字段
  private int heightInCM;

  public int getHeightInCM() {
    return heightInCM;
  }

  public void setHeightInCM(int heightInCM) {
    // this指代了调用这个实例方法的对象，当局部变量名和实例成员变量名字冲突的时候。
    // 使用this区分局部变量和实例成员。this.成员变量名
    this.heightInCM = heightInCM;
  }
}
