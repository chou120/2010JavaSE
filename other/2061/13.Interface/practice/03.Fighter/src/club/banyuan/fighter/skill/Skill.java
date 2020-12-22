package club.banyuan.fighter.skill;

import club.banyuan.fighter.Fighter;
import club.banyuan.fighter.common.FightAble;

public interface Skill extends FightAble {

  boolean coolDown();

  void nextRound();

  void addRound(int count);
}
