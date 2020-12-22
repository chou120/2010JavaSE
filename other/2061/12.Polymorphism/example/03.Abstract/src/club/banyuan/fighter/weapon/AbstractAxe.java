package club.banyuan.fighter.weapon;

import club.banyuan.fighter.Fighter;

abstract public class AbstractAxe extends AbstractWeapon {

  public AbstractAxe(String name) {
    super(name);
  }

  abstract public void breakArmor(Fighter from, Fighter to);

  @Override
  public void attack(Fighter from, Fighter to) {
    // 攻击之前先破甲
    int attack = from.attack();
    breakArmor(from, to);
    to.hurt(attack);
    System.out
        .println(
            from.getName() + "使用" + getName() + "向" + to.getName() + "发起攻击," + attack + "，剩余血量："
                + to.getHp());
  }
}
