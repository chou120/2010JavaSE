package club.banyuan.fighter.skill;

import club.banyuan.fighter.Fighter;
import club.banyuan.fighter.common.FightAble;

//额外的buff
public interface Buff extends FightAble {

  boolean isExist();

  void nextRound();
}
