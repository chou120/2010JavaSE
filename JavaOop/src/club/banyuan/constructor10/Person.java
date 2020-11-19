package club.banyuan.constructor10;

/**
 * @author sanye
 * @version 1.0
 * @date 2020/11/19 10:52 上午
 */
public class Person {

  private String name;
  private int address;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getAddress() {
    return address;
  }

  public void setAddress(int address) {
    this.address = address;
  }

//  private Person() {    //
//    System.out.println("私有化构造器...");
//  }
//
//  //构造器私有化了 能不能在本类中创建Person对象
//  public static Person createPerson() {
//    return new Person();  //已经创建好的对象
//  }

//  Person(){
//    System.out.println("默认的 访问权限");
//  }

//    protected  Person(){
//
//    }

  @Override
  public String toString() {
    return "Person{" +
        "name='" + name + '\'' +
        ", address=" + address +
        '}';
  }

  public static void showInfo() {
    System.out.println("我是static静态方法...");
  }
}

class TestPerson {

  public static void main(String[] args) {
    // Person  person=new   Person("张三",45);
    //如果只有一个显示的有参构造 那么只能通过这个显示的构造器来创建对象
    // new Person();

    //被static修饰的成员可以直接通过类名.成员调用(非私有化的成员)
//    Person.showInfo();
//
//    Person person = Person.createPerson();
//    person.setName("邢健");
//    person.setAddress(12);
//
//    System.out.println(person.toString());

     Person person = new Person();


  }

}
