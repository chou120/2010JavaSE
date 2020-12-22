package club.banyuan.fighter.skill;

public abstract class AbstractSkill implements Skill {

  protected int coolDown = 1;

  @Override
  public boolean coolDown() {
    return coolDown == 0;
  }

  @Override
  public void nextRound() {
    if (coolDown > 0) {
      coolDown--;
    }
  }

  @Override
  public void addRound(int count) {
    coolDown += count;
    if (coolDown < 0) {
      coolDown = 0;
    }
  }
}
