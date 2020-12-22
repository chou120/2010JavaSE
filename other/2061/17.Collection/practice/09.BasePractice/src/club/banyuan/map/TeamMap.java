package club.banyuan.map;

import club.banyuan.Player;
import club.banyuan.Position;
import club.banyuan.set.TeamSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class TeamMap {

  private Map<Integer, Player> players = new HashMap<>();

  public void addPlayer(Player player) {
    players.put(player.getNum(), player);
  }

  // 张三  = {"张三"，C，22}
  // 李四  = {"李四", PG, 33}
  public Player findByNum(int num) {
    return players.get(num);
    // // 遍历Map
    // // 通过entrySet 获取映射关系的集合
    // // 遍历集合拿到每一个映射关系的对象。
    // Set<Entry<Integer, Player>> entries = players.entrySet();
    // for (Entry<Integer, Player> one : entries) {
    //   Integer key = one.getKey();
    //   Player value = one.getValue();
    //   if (num == key) {
    //     return value;
    //   }
    // }
    // return null;
  }

  public Player findByName(String name) {
    // Set<Integer> integers = players.keySet();
    // for (Integer integer : integers) {
    //   Player player = players.get(integer);
    //   if (player.getName().equals(name)) {
    //     return player;
    //   }
    // }

    Collection<Player> values = players.values();
    for (Player value : values) {
      if (value.getName().equals(name)) {
        return value;
      }
    }

    return null;
  }

  public void deleteByPosition(Position position) {
    Iterator<Entry<Integer, Player>> iterator = players.entrySet().iterator();
    while (iterator.hasNext()) {
      if (iterator.next().getValue().getPosition() == position) {
        iterator.remove();
      }
    }

    // for (Entry<Integer, Player> entry : players.entrySet()) {
    //   if (entry.getValue().getPosition() == position) {
    //     set.add(entry.getKey());
    //     // 不能直接删除
    //     // players.remove(entry.getKey());
    //   }
    // }

  }

  @Override
  public String toString() {
    return "TeamMap{" +
        "players=" + players +
        '}';
  }

  /**
   * 根据球员的编号，更新保存了的球员的信息
   *
   * @param player
   */
  public void updatePlayerByNum(Player player) {
    players.put(player.getNum(), player);
  }

  // 球员列表根据位置排序，从1号位到5号位排序
  public List<Player> sortByPosition() {
    List<Player> playerList = new ArrayList<>(players.values());
    playerList.sort(Comparator.comparing(Player::getPosition));
    return playerList;
  }

  // 根据球员号码从高到低排序
  public List<Player> sortByNum() {
    List<Player> playerList = new ArrayList<>(players.values());
    playerList.sort((p1, p2) -> p2.getNum() - p1.getNum());
    return playerList;
  }

  public static void main(String[] args) {
    // Map<String, Integer> map = new HashMap<>();
    // map.put("123", 1111);
    // map.put("222", 1234);

    // System.out.println("222".hashCode() % 16);
    // System.out.println("123".hashCode() % 16);

    // System.out.println(map);
    //
    // Set<Entry<String, Integer>> entries = map.entrySet();
    // for (Entry<String, Integer> entry : entries) {
    //   System.out.println(entry.getKey());
    //   System.out.println(entry.getValue());
    // }
    //
    // Set<String> strings = map.keySet();

    TeamMap teamMap = new TeamMap();
    Player p1 = new Player("p1", Position.C, 1);
    Player p2 = new Player("p2", Position.PF, 2);
    Player p3 = new Player("p3", Position.PG, 3);
    Player p4 = new Player("p4", Position.SF, 4);
    Player p5 = new Player("p5", Position.SG, 5);

    System.out.println(teamMap);

    teamMap.addPlayer(p1);
    teamMap.addPlayer(p2);
    teamMap.addPlayer(p3);
    teamMap.addPlayer(p4);
    teamMap.addPlayer(p5);
    System.out.println("add:");
    System.out.println(teamMap);
    System.out.println("根据p2名字查找");
    System.out.println(teamMap.findByName("p2"));
    System.out.println("根据num 3查找");
    System.out.println(teamMap.findByNum(3));
    System.out.println("删除C位置的球员");

    teamMap.deleteByPosition(Position.C);
    System.out.println(teamMap);
    System.out.println("根据编号更新");
    Player p6 = new Player("p6", Position.C, 5);
    teamMap.updatePlayerByNum(p6);
    System.out.println(teamMap);

    List<Player> players = teamMap.sortByPosition();
    System.out.println(players);

    players = teamMap.sortByNum();
    System.out.println(players);
  }
}
