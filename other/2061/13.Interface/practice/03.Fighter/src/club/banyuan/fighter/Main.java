package club.banyuan.fighter;

import club.banyuan.fighter.skill.RecoverSkill;
import club.banyuan.fighter.skill.VertigoSkill;
import club.banyuan.fighter.weapon.SpearWeapon;
import club.banyuan.fighter.weapon.Sword;

public class Main {

  public static void main(String[] args) {
    Fighter f1 = new Fighter("吕布", new Sword());
    Fighter f2 = new Fighter("张飞", new Sword());
    f1.addSkill(new RecoverSkill());
    f2.addSkill(new VertigoSkill());
    while (f1.getHp() > 0 && f2.getHp() > 0) {
      f1.attack(f2);
      if (f2.getHp() > 0) {
        f2.attack(f1);
      }
    }

    if (f1.getHp() > 0) {
      System.out.println(f1.getName() + "获胜,剩余血量" + f1.getHp());
    } else {
      System.out.println(f2.getName() + "获胜,剩余血量" + f2.getHp());
    }
  }
}
