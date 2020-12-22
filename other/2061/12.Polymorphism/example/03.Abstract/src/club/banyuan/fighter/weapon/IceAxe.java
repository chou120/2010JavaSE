package club.banyuan.fighter.weapon;

import club.banyuan.fighter.Fighter;

public class IceAxe extends AbstractAxe {

  public IceAxe() {
    super("寒冰斧");
  }

  @Override
  public void breakArmor(Fighter from, Fighter to) {
    int armor = to.getArmor() - 50;
    to.setArmor(Math.max(0, armor));
    System.out.println(to.getName() + "护甲值减少:" + Math.max(0, armor));
  }
}
