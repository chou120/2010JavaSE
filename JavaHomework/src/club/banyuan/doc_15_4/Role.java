package club.banyuan.doc_15_4;

/**
 * @author sanye
 * @version 1.0
 * @date 2020/11/26 9:28 上午
 */
public abstract class Role {

  private String name="李四";
  private int age;
  private char sex;

  public Role() {
  }

  public Role(String name, int age, char sex) {
    this.name = name;
    this.age = age;
    this.sex = sex;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public char getSex() {
    return sex;
  }

  public void setSex(char sex) {
    this.sex = sex;
  }

  public abstract void play();

  @Override
  public String toString() {
    return "Role{" +
        "name='" + this.name + '\'' +
        ", age=" + this.age +
        ", sex=" + this.sex +
        '}';
  }
}
