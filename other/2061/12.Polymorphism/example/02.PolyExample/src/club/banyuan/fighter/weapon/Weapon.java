package club.banyuan.fighter.weapon;

import club.banyuan.fighter.Fighter;

public class Weapon {

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

  public void attack(Fighter from, Fighter to) {
    int attack = from.attack();
    int hp = to.getHp();
    to.setHp(hp - attack * 2);
    System.out
        .println(
            from.getName() + "使用" + name + "向" + to.getName() + "发起攻击," + (attack * 2) + "，剩余血量："
                + to.getHp());
  }
}
