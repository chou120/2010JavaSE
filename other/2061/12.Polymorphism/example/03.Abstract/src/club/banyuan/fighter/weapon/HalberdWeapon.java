package club.banyuan.fighter.weapon;

import club.banyuan.fighter.Fighter;

public class HalberdWeapon extends AbstractWeapon {

  private int attack = 100;

  public HalberdWeapon() {
    super("方天画戟");
  }

  @Override
  public void attack(Fighter from, Fighter to) {
    int attack = from.attack() + this.attack;
    to.hurt(attack);
    System.out
        .println(
            from.getName() + "使用" + getName() + "向" + to.getName() + "发起攻击," + attack + "，剩余血量："
                + to.getHp());
  }
}
