package club.banyuan.Oop2;

/**
 * @author sanye
 * @version 1.0
 * @date 2020/11/17 10:52 上午
 */
public class Student {

  /**
   * 私有化属性和公有化方法的集合
   */

  private  String  name="张三";
  private  int age=120;

  public void setName(String name) {
    this.name = name;  //没有传值成功
    System.out.println(this);
    // this 指向的是内存中当前对象(所创建的对象在堆内存中的地址)
    setAge(23);
    //System.out.println(this.getAge());
  }

  public int getAge() {
    return this.age;
  }

  public void setAge(int newAge) {  //
    this.age = newAge;
  }

  public String getName() {
    return this.name;
  }

  public String toString() {
    return "Student{" +
        "name='" + this.name + '\'' +
        ", age=" + this.age +
        '}';
  }
}

class  TestMain{

  public static void main(String[] args) {
    Student student = new Student();
    student.setName("行健");
    System.out.println(student);

    Student student2 = new Student();
    student2.setName("天行健");
    //student2.setAge(12);
    student2.setAge(22);

    System.out.println(student2);


  }
}