package club.team;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sanye
 * @version 1.0
 * @date 2020/12/3 1:39 下午
 */
public class Test {

  public static void main(String[] args) {

    List<Player> list=new ArrayList<>();  //
    Player player1 = new Player("麦迪", 1, "SG");
    Player player2 = new Player("姚明", 11, "C");
    Player player3 = new Player("海耶斯", 13, "PF");
    Player player4 = new Player("罗瑞", 7, "PG");
    Player player5 = new Player("阿泰斯特", 96, "SF");
    list.add(player1);
    list.add(player2);
    list.add(player3);
    list.add(player4);
    list.add(player5);

    List<Player> list2=new ArrayList<>();
    Player player6 = new Player("布鲁克斯", 00, "PG");
    Player player7 = new Player("巴蒂尔", 31, "SF");
    Player player8 = new Player("佛兰西斯", 13, "SG");
    Player player9 = new Player("斯卡拉", 25, "C");
    Player player10 = new Player("兰德尔", 35, "PF");
    Player player11 = new Player("不认识1", 37, "SF");
    Player player12 = new Player("不认识2", 90, "PF");
    list2.add(player6);
    list2.add(player7);
    list2.add(player8);
    list2.add(player9);
    list2.add(player10);
    list2.add(player11);
    list2.add(player12);

    Team team = new Team();
    team.setStartPlayers(list);
    team.setWaitPlayers(list2);

    List<Player> players=new ArrayList<>();
    players.add(player8);
    players.add(player9);
    players.add(player10);

    team.replaceStartPlayers(players);

    //team.replacePlayer(player6);
    team.print();


  }
}
