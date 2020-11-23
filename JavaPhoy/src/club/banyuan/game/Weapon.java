package club.banyuan.game;

/**
 * @author sanye
 * @version 1.0
 * @date 2020/11/23 3:36 下午
 */
public class Weapon {
  private String name;//武器的名字
  public Weapon() {
  }
  public Weapon(String name) {
    this.name = name;
  }
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  public void attack(Fighter fighter1, Fighter fighter2) {  //一个回合的
    int attack = fighter1.attack();
    int hp = fighter2.getHp();
    hp = hp - attack;
    fighter2.setHp(hp);
    System.out
        .println(fighter1.getName() + "向" + fighter2.getName() + "发起了攻击,造成的伤害为:" + attack + ","
            + fighter2.getName() + "还剩下的血量为:" + fighter2.getHp());
  }
}
