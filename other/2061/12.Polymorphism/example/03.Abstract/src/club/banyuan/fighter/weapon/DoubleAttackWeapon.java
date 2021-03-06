package club.banyuan.fighter.weapon;

import club.banyuan.fighter.Fighter;

public class DoubleAttackWeapon extends AbstractWeapon {

  public DoubleAttackWeapon(String name) {
    super(name);
  }

  @Override
  public void attack(Fighter from, Fighter to) {
    int attack = from.attack();
    int hp = to.getHp();
    to.hurt(attack * 2);
    to.setHp(hp - attack * 2);
    System.out
        .println(
            from.getName() + "使用" + name + "向" + to.getName() + "发起攻击," + (attack * 2) + "，剩余血量："
                + to.getHp());
  }
}
