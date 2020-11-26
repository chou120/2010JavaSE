package club.banyuan.api;

/**
 * @author sanye
 * @version 1.0
 * @date 2020/11/26 10:48 上午
 */
public class Student implements Cloneable {

  private String name = "哈哈是";
  private int age = 12;
  private String address;

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Override
  public String toString() {
    return "Student{" +
        "name='" + name + '\'' +
        ", age=" + age +
        ", address='" + address + '\'' +
        '}';
  }

  //判断对象是否相等  主要是去比较其内的属性值 不去考虑其地址
  public boolean equals(Object object) { //
    // 在什么情况下不需要进行两个对象比较
    if (object == null) {
      return false;
    }
    if (this.getClass() != object.getClass()) {
      return false;
    }
    //比较传递过来的对象和当前对象里面的属性值一一对比
    Student stu = (Student) object;
    if (!this.getName().equals(stu.getName())) {
      return false;
    }
    if (this.getAge() != stu.getAge()) {
      return false;
    }
    if (!this.getAddress().equals(stu.getAddress())) {
      return false;
    }
    return true;
  }

  @Override
  protected Object clone() throws CloneNotSupportedException {
    return super.clone();
  }
}
