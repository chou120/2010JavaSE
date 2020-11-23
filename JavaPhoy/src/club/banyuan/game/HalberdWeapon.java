package club.banyuan.game;

/**
 * @author sanye
 * @version 1.0
 * @date 2020/11/23 3:48 下午
 */
public class HalberdWeapon extends Weapon {


  private int attack; //武器本身伤害的20%

  public HalberdWeapon() {
   super("方天画戟");
  }

  @Override
  public void attack(Fighter fighter1, Fighter fighter2) {
    int attack = fighter1.attack();
    //武器的攻击
    int hw = (int) (attack * 1.5);

    this.attack = (int) (hw * 0.2);

    int total = attack + hw + this.attack;
    int hp = fighter2.getHp();
    fighter2.setHp(hp - total);

    System.out
        .println(fighter1.getName() + "向" + fighter2.getName() + "发起了攻击,造成的伤害为:" + total + ","
            + fighter2.getName() + "还剩下的血量为:" + fighter2.getHp());
  }
}
