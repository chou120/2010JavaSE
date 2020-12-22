package club.banyuan.fighter.weapon;

import club.banyuan.fighter.Fighter;
import club.banyuan.fighter.common.FightAble;

public class Weapon implements FightAble {

  private String name;

  public Weapon(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Override
  public void fight(Fighter from, Fighter to) {
    int attack = from.attack();
    int hp = to.getHp();
    to.setHp(hp - attack * 2);
    System.out
        .println(
            from.getName() + "使用" + name + "向" + to.getName() + "发起攻击," + (attack * 2) + "，剩余血量："
                + to.getHp());
  }
}
