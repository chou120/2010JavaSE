package club.banyuan.doc15_3;

/**
 * @author sanye
 * @version 1.0
 * @date 2020/11/26 9:11 上午
 */
public abstract class Animal {
  private  String  name;
  private  int  age;

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

  @Override
  public String toString() {
    return "Animal{" +
        "name='" + name + '\'' +
        ", age=" + age +
        '}';
  }

  public abstract void  eat();

}
