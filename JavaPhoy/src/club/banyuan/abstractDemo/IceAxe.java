package club.banyuan.abstractDemo;

/**
 * @author sanye
 * @version 1.0
 * @date 2020/11/23 5:09 下午
 */
public class IceAxe  extends  Weapon {

  public  void  getInfo(){
    System.out.println("这是抽象类的子类里面的普通方法...");
  }

  public IceAxe(String name) {
    super(name);
  }
}
