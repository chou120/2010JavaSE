package club.banyuan.abstractDemo;

/**
 * @author sanye
 * @version 1.0
 * @date 2020/11/23 5:08 下午
 */
public abstract class Weapon {

  private String name;

  private  static  int  age=12;

  private final  String  ADDRESS=":";

  private static  final String  COUNTRY="china";

  public  abstract  void  getInfo();


  public  static  void  method(){

  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Weapon() {
    System.out.println("这是抽象父类的无参构造器....");
  }

  public Weapon(String name) {
    this.name = name;
    System.out.println("这是抽象父类的有参构造器....");

  }
}