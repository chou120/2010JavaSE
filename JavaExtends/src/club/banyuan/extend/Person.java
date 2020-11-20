package club.banyuan.extend;

/**
 * @author sanye
 * @version 1.0
 * @date 2020/11/20 9:20 上午
 */
public class Person {
  //  超类   父类   基类

  private   String name;
  private  char  sex;
  private  int  age;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public char getSex() {
    return sex;
  }

  public void setSex(char sex) {
    this.sex = sex;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  @Override
  public String toString() {
    return "Person{" +
        "name='" + name + '\'' +
        ", sex=" + sex +
        ", age=" + age +
        '}';
  }


  public  void   study(){
    System.out.println("父类靠实践...学习的功能");

  }


}
