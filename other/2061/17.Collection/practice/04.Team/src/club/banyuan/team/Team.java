package club.banyuan.team;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class Team {

  //首发
  private List<Player> starting = new ArrayList<>();
  //替补
  private List<Player> substitution = new ArrayList<>();

  public List<Player> getStarting() {
    return starting;
  }

  public void setStarting(List<Player> starting) {
    this.starting = starting;
  }

  public List<Player> getSubstitution() {
    return substitution;
  }

  public void setSubstitution(List<Player> substitution) {
    this.substitution = substitution;
  }

  /**
   * 如果球员不在大名单里面，如果首发不足5人，则添加球员到首发阵容，否则添加到替补球员
   *
   * @param player
   */
  public void add(Player player) {
    if (!starting.contains(player) && starting.size() < 5) {
      starting.add(player);
    } else {
      substitution.add(player);
    }
  }

  /**
   * 返回第一个查到找到该位置的球员
   *
   * @param players
   */
  private Player getByPosition(List<Player> players, String position) {
    for (Player player : players) {
      if (position.equals(player.getPosition())) {
        return player;
      }
    }
    throw new RuntimeException("没有找到该位置的球员");
  }

  public void replace(Player player) {
    Player startPlayer = getByPosition(starting, player.getPosition());
    starting.remove(startPlayer);
    substitution.remove(player);
    starting.add(player);
    substitution.add(startPlayer);
    starting.sort(Comparator.comparingInt(Player::getPositionIndex));
    substitution.sort(Comparator.comparingInt(Player::getPositionIndex));
  }

  public void remove(Player player) {
    if (starting.remove(player)) {
      Player byPosition = null;
      try {
        byPosition = getByPosition(substitution, player.getPosition());
        starting.add(byPosition);
        substitution.remove(byPosition);
        starting.sort(Comparator.comparingInt(Player::getPositionIndex));
      } catch (RuntimeException e) {
        System.err.println("没有相同位置的替补");
      }
    } else {
      substitution.remove(player);
    }
  }


  public void replace(List<Player> players) {
    List<Player> all = new ArrayList<>(starting);  //将首发添加到新的集合中去
    all.addAll(substitution); // 将替补也添加到新的集合中去

    starting.clear(); //清空 首发 集合
    if (players.size() > 5) { //如果替代的集合人数players数量超过5
      throw new RuntimeException("人数不合法");
    }
    starting.addAll(players);  //如果添加的数量没有超过五个 就将需要添加的数据

    List<String> positions = new ArrayList<>();
    for (Player player : starting) {
      if (positions.contains(player.getPosition())) {
        throw new RuntimeException("位置重复了");
      }
      positions.add(player.getPosition());
    }

    Iterator<Player> iterator = all.iterator();
    while (iterator.hasNext()) {
      Player next = iterator.next();
      if (!positions.contains(next.getPosition())) {
        starting.add(next);
        positions.add(next.getPosition());
        iterator.remove();
      }
    }

    if (starting.size() < 5) {
      throw new RuntimeException("人数不够了");
    }
    starting.sort(Comparator.comparingInt(Player::getPositionIndex));
    substitution = all;
    substitution.removeAll(starting);
    substitution.sort(Comparator.comparingInt(Player::getPositionIndex));

  }


  public void print() {
    System.out.println("====首发====");
    System.out.println(starting);
    System.out.println("====替补====");
    System.out.println(substitution);
  }
}
