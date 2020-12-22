package club.banyuan.fighter.weapon;

import club.banyuan.fighter.Fighter;
import java.util.Random;

public class SpearWeapon extends Weapon {

  public SpearWeapon() {
    super("丈八蛇矛");
  }

  public void fight(Fighter from, Fighter to) {
    Random random = new Random();
    int attack = from.attack() + (random.nextInt(250) + 50);
    int hp = to.getHp();
    to.setHp(hp - attack);
    System.out
        .println(
            from.getName() + "使用" + getName() + "向" + to.getName() + "发起攻击," + attack + "，剩余血量："
                + to.getHp());
  }
}
