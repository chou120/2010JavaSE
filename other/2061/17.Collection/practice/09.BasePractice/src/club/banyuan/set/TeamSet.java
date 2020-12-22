package club.banyuan.set;

import club.banyuan.Player;
import club.banyuan.Position;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class TeamSet {

  private Set<Player> players = new HashSet<>();

  public void addPlayer(Player player) {
    players.add(player);
  }

  public Player findByNum(int num) {
    for (Player player : players) {
      if (num == player.getNum()) {
        return player;
      }
    }
    return null;
  }

  public Player findByName(String name) {
    for (Player player : players) {
      if (name.equals(player.getName())) {
        return player;
      }
    }
    return null;
  }

  public void deleteByPosition(Position position) {
    Iterator<Player> iterator = players.iterator();

    while (iterator.hasNext()) {
      if (position.equals(iterator.next().getPosition())) {
        iterator.remove();
      }
    }
  }

  @Override
  public String toString() {

    String rlt = "";
    for (Player player : players) {
      rlt += player;
      rlt += "\n";
    }
    return rlt;
  }

  /**
   * 根据球员的编号，更新保存了的球员的信息
   *
   * @param player
   */
  public void updatePlayerByNum(Player player) {
    Player byNum = findByNum(player.getNum());
    players.remove(byNum);
    players.add(player);
  }

  // 球员列表根据位置排序，从1号位到5号位排序
  public List<Player> sortByPosition() {
    List<Player> playerList = new ArrayList<>(players);
    playerList.sort(Comparator.comparing(Player::getPosition));

    // 使用treeset进行排序
    // TreeSet<Player> treeSet = new TreeSet<>(
    //     Comparator.comparing(Player::getPosition));
    // treeSet.addAll(players);
    // return new ArrayList<>(treeSet);

    // playerList.sort(new Comparator<Player>() {
    //   @Override
    //   public int compare(Player o1, Player o2) {
    //     return o1.getPosition().compareTo(o2.getPosition());
    //   }
    // });
    return playerList;
  }

  // 根据球员号码从高到低排序
  public List<Player> sortByNum() {
    List<Player> playerList = new ArrayList<>(players);
    // playerList.sort(Comparator.comparingInt(Player::getNum));
    playerList.sort((o1, o2) -> o2.getNum() - o1.getNum());

    playerList.sort(new Comparator<Player>() {
      @Override
      public int compare(Player o1, Player o2) {
        return o2.getNum() - o1.getNum();
      }
    });
    return playerList;
  }

  public static void main(String[] args) {
    TeamSet teamSet = new TeamSet();
    Player p1 = new Player("p1", Position.C, 1);
    Player p2 = new Player("p2", Position.PF, 2);
    Player p3 = new Player("p3", Position.PG, 3);
    Player p4 = new Player("p4", Position.SF, 4);
    Player p5 = new Player("p5", Position.SG, 5);

    System.out.println(teamSet);

    teamSet.addPlayer(p1);
    teamSet.addPlayer(p2);
    teamSet.addPlayer(p3);
    teamSet.addPlayer(p4);
    teamSet.addPlayer(p5);
    System.out.println("add:");
    System.out.println(teamSet);
    System.out.println("根据p2名字查找");
    System.out.println(teamSet.findByName("p2"));
    System.out.println("根据num 3查找");
    System.out.println(teamSet.findByNum(3));
    System.out.println("删除C位置的球员");

    teamSet.deleteByPosition(Position.C);
    System.out.println(teamSet);
    System.out.println("根据编号更新");
    Player p6 = new Player("p6", Position.C, 5);
    teamSet.updatePlayerByNum(p6);
    System.out.println(teamSet);

    List<Player> players = teamSet.sortByPosition();
    System.out.println(players);

    players = teamSet.sortByNum();
    System.out.println(players);
  }
}
