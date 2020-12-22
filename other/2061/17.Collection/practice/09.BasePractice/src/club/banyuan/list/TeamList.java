package club.banyuan.list;

import club.banyuan.Player;
import club.banyuan.Position;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class TeamList {

  private List<Player> players = new ArrayList<>();

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
    // for (int i = 0; i < end; i++) {
    //   if (position.equals(players.get(i).getPosition())) {
    //     players.remove(i);
    //   }
    // }
  }

  @Override
  public String toString() {
    // return "TeamList{" +
    //     "players=" + players +
    //     '}';

    // StringBuilder stringBuilder = new StringBuilder();
    // for (Player player : players) {
    //   stringBuilder.append(player);
    //   stringBuilder.append(System.lineSeparator());
    // }
    // return stringBuilder.toString();

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

    // 方式1
    // Player byNum = findByNum(player.getNum());
    // if (byNum == null) {
    //   return;
    // }
    // byNum.setPosition(player.getPosition());
    // byNum.setName(player.getName());

    // 方式2
    // for (Player player1 : players) {
    //   if (player1.getNum() == player.getNum()) {
    //     player1.setName(player.getName());
    //     player1.setPosition(player.getPosition());
    //   }
    // }

    // 方式3

    // int index = -1;
    // for (int i = 0; i < players.size(); i++) {
    //   if (players.get(i).getNum() == player.getNum()) {
    //     index = i;
    //   }
    // }
    // if (index != -1) {
    //   players.set(index, player);
    // }

    for (int i = 0; i < players.size(); i++) {
      if (players.get(i).getNum() == player.getNum()) {
        players.set(i, player);
        break;
      }
    }
  }

  // 球员列表根据位置排序，从1号位到5号位排序
  public void sortByPosition() {
    players.sort(new Comparator<Player>() {
      @Override
      public int compare(Player o1, Player o2) {
        return o1.getPosition().compareTo(o2.getPosition());
      }
    });

    // for (int i = 0; i < players.size(); i++) {
    //   for (int j = i; j < players.size(); j++) {
    //     // ?? = players.get(j) 比较( players.get(i))
    //     // ?? 第一个大还是第二个大
    //     int result = players.get(i).getPosition().compareTo(players.get(j).getPosition());
    //     if (result > 0) {
    //       Player temp = players.get(i);
    //       players.set(i, players.get(j));
    //       players.set(j, temp);
    //     }
    //   }
    // }
  }

  // 根据球员号码从高到低排序
  public void sortByNum() {
    players.sort(new Comparator<Player>() {
      @Override
      public int compare(Player o1, Player o2) {
        return o1.getNum() - o2.getNum();
      }
    });

    players.sort(Comparator.comparingInt(Player::getNum));

    for (int i = 0; i < players.size(); i++) {
      for (int j = i; j < players.size(); j++) {
        // ?? = players.get(j) 比较( players.get(i))
        // ?? 第一个大还是第二个大
        int result = players.get(i).getNum() - players.get(j).getNum();
        if (result > 0) {
          Player temp = players.get(i);
          players.set(i, players.get(j));
          players.set(j, temp);
        }
      }
    }
  }

  public static void main(String[] args) {
    TeamList teamList = new TeamList();
    Player p1 = new Player("p1", Position.C, 1);
    Player p2 = new Player("p2", Position.PF, 2);
    Player p3 = new Player("p3", Position.PG, 3);
    Player p4 = new Player("p4", Position.SF, 4);
    Player p5 = new Player("p5", Position.SG, 5);

    System.out.println(teamList);

    teamList.addPlayer(p1);
    teamList.addPlayer(p2);
    teamList.addPlayer(p3);
    teamList.addPlayer(p4);
    teamList.addPlayer(p5);
    System.out.println("add:");
    System.out.println(teamList);
    System.out.println("根据p2名字查找");
    System.out.println(teamList.findByName("p2"));
    System.out.println("根据num 3查找");
    System.out.println(teamList.findByNum(3));
    System.out.println("删除C位置的球员");

    teamList.deleteByPosition(Position.C);
    System.out.println(teamList);
    System.out.println("根据编号更新");
    Player p6 = new Player("p6", Position.C, 5);
    teamList.updatePlayerByNum(p6);
    System.out.println(teamList);

    teamList.sortByPosition();
    System.out.println(teamList);

    teamList.sortByNum();
    System.out.println(teamList);
  }

  // public void sortByNum(比较方法) {
  //   for (int i = 0; i < players.size(); i++) {
  //     for (int j = i; j < players.size(); j++) {
  //       // ?? = players.get(j) 比较( players.get(i))
  //       // ?? 第一个大还是第二个大
  //       int result = 比较方法(players.get(i), players.get(j));
  //       if(result > 0){
  //
  //       }
  //     }
  //   }
  // }

  // public void sortByNum(CompareRule rule) {
  //   for (int i = 0; i < players.size(); i++) {
  //     for (int j = i; j < players.size(); j++) {
  //       // ?? = players.get(j) 比较( players.get(i))
  //       // ?? 第一个大还是第二个大
  //       int result = rule.compareByNum(players.get(i), players.get(j));
  //       if (result > 0) {
  //         Player temp = players.get(i);
  //         players.set(i, players.get(j));
  //         players.set(j, temp);
  //       }
  //     }
  //   }
  // }
}
