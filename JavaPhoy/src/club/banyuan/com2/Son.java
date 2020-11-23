package club.banyuan.com2;

/**
 * @author sanye
 * @version 1.0
 * @date 2020/11/23 2:14 下午
 */
public class Son  extends Person{

  public    String address="玄武-son";

  @Override
  public void study() {
    System.out.println("这是子类学习的方法...学习的是小学内容");
  }

  public  static  void  makeMoney(){
    System.out.println("这是子类挣钱的方法...");
  }

  public  String  getAddress(){
    return address;
  }

  public  void  useParent(){
    System.out.println("子类啃老");
  }



}
