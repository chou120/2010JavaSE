package club.banyuan.gamePhoy;

/**
 * @author sanye
 * @version 1.0
 * @date 2020/11/23 4:41 下午
 */
public class Tool {

  private Tool() {

  }
  //多态
  public static void getWeapon(Weapon weapon){
    if (weapon instanceof HalberdWeapon) {  //用来判断传递过来对象是否是 HalberdWeapon类型的
      weapon.reset("钛合金为主材料");
    } else if (weapon instanceof SpearWeapon) {
      weapon.reset("天外陨铁为主材料");
    }
  }
}
