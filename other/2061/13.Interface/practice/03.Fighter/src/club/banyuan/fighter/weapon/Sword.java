package club.banyuan.fighter.weapon;

import club.banyuan.fighter.Fighter;

public class Sword extends Weapon {

  private int attack = 50;

  public Sword() {
    super("双股剑");
  }

  @Override
  public void fight(Fighter from, Fighter to) {
    int attack = from.attack() + this.attack;
    int hp = to.getHp();
    to.setHp(hp - attack);
    System.out
        .println(
            from.getName() + "使用" + getName() + "向" + to.getName() + "发起攻击," + attack + "，剩余血量："
                + to.getHp());
    System.out.println("属性成长");
    this.attack += 50;
  }
}
