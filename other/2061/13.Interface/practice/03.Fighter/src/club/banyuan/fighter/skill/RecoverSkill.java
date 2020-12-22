package club.banyuan.fighter.skill;

import club.banyuan.fighter.Fighter;
import java.util.Random;

/**
 * 给自己恢复生命值
 */
public class RecoverSkill extends AbstractSkill {

  private static final int COOL_DOWN_TIME = 2;

  @Override
  public void fight(Fighter from, Fighter to) {
    int hp = from.getHp();
    int recover = new Random().nextInt(100) + 200;
    System.out.println(from.getName() + "释放了恢复技能，恢复生命值" + recover);
    hp += recover;
    from.setHp(hp);
    coolDown = COOL_DOWN_TIME;
  }
}
