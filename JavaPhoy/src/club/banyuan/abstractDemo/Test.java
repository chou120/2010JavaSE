package club.banyuan.abstractDemo;

/**
 * @author sanye
 * @version 1.0
 * @date 2020/11/23 5:06 下午
 */
public class Test {

  public static void main(String[] args) {

    Weapon weapon = new IceAxe("萨达as吗");  // 抽象类多态
   // weapon.getInfo();
    System.out.println(weapon.getName());
  }


}
