package club.banyuan.fighter;

import club.banyuan.fighter.skill.Buff;
import club.banyuan.fighter.skill.Skill;
import club.banyuan.fighter.weapon.Weapon;
import java.util.Arrays;
import java.util.Random;

public class Fighter {

  private Random random = new Random();

  private int hp = 1000;
  private String name;
  private Weapon weapon;
  private Skill[] skills = new Skill[0];
  private Buff[] buffs = new Buff[0];
  private int vertigoValue = 0;

  public Fighter(String name) {
    this.name = name;
  }

  public Fighter(String name, Weapon weapon) {
    this.name = name;
    this.weapon = weapon;
  }

  public int getHp() {
    return hp;
  }

  public void setHp(int hp) {
    this.hp = hp;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void attack(Fighter fighter) {
    if (!attackAble()) {
      System.out.println("眩晕状态");
    } else {
      boolean isCastSkill = false;
      for (Skill skill : skills) {
        if (!isCastSkill && skill.coolDown()) {
          skill.fight(this, fighter);
          isCastSkill = true;
          break;
        }
      }
      if (!isCastSkill) {
        weapon.fight(this, fighter);
      }
    }
    nextRound();
  }
  public void vertigo(int val) {
    vertigoValue += val;
  }

  private void nextRound() {
    if (vertigoValue > 0) {
      vertigoValue--;
    }
    for (Skill skill : skills) {
      skill.nextRound();
    }
  }

  public boolean attackAble() {
    return vertigoValue == 0;
  }

  public int attack() {
    return random.nextInt(100) + 100;
  }

  public void addSkill(Skill skill) {
    if (skills == null) {
      skills = new Skill[1];
      skills[0] = skill;
    } else {
      skills = Arrays.copyOf(skills, skills.length + 1);
      skills[skills.length - 1] = skill;
    }
  }
}
