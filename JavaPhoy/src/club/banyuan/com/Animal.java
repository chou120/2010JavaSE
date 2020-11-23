package club.banyuan.com;

/**
 * @author sanye
 * @version 1.0
 * @date 2020/11/23 1:55 下午
 */
public class Animal {

  private  String  name;
  private  int age;
  private  int  color;

  //吃饭的行为
  public   void    eat(){
    System.out.println("动物在吃...");
  }


  @Override
  public String toString() {
    return "Animal{" +
        "name='" + name + '\'' +
        ", age=" + age +
        ", color=" + color +
        '}';
  }

  public Animal() {
  }

  public Animal(String name, int age, int color) {
    this.name = name;
    this.age = age;
    this.color = color;
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

  public int getColor() {
    return color;
  }

  public void setColor(int color) {
    this.color = color;
  }
}
