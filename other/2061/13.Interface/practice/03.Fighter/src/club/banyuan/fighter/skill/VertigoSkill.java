package club.banyuan.fighter.skill;

import club.banyuan.fighter.Fighter;
import java.util.Random;

/**
 * 击晕对手一回合
 */
public class VertigoSkill extends AbstractSkill {

  private static final int COOL_DOWN_TIME = 4;

  @Override
  public void fight(Fighter from, Fighter to) {
    System.out.println(from.getName() + "释放了击晕技能，" + to.getName() + "被击晕一回合");
    to.vertigo(1);
    coolDown = COOL_DOWN_TIME;
  }
}
