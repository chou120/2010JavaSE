package club.banyuan.extend4;

/**
 * @author sanye
 * @version 1.0
 * @date 2020/11/20 10:34 上午
 */
public class Father{

  /**
   * 子类不能继承父类的构造方法，但是可以通过super(后面讲)关键字去访问父类构造方法。
   */
  private  String  name;
  private  String address;

  public Father(){
    //super();
    System.out.println("这是父类的无参构造方法...");
  }

  public Father(String name, String address) {
    //super(); // 调用的是Object的无参构造器
    this.name = name;
    this.address = address;
    System.out.println("这是父类都有参构造方法...");
  }
}
