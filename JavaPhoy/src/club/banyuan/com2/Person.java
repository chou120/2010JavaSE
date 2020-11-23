package club.banyuan.com2;

/**
 * @author sanye
 * @version 1.0
 * @date 2020/11/23 2:12 下午
 */
public class Person {


  private   String name;
  public    String address="栖霞-father";
  public  static  int  AGE=12;

  //静态方法...
  public  static  void  makeMoney(){
    System.out.println("这是父类挣钱的方法...");
  }


  public  String getAddress(){
    return address;
  }

  //自主学习的方法...
  public   void   study(){
    System.out.println("这是父类自主学习的方法...");
  }


  public Person() {
  }

  public Person(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
