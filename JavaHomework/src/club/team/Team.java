package club.team;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sanye
 * @version 1.0
 * @date 2020/12/3 1:39 下午
 */
public class Team {  //12

  private List<Player> startPlayers = new ArrayList<>(); //首发
  private List<Player> waitPlayers = new ArrayList<>(); //替补

  public List<Player> getStartPlayers() {
    return startPlayers;
  }

  public void setStartPlayers(List<Player> startPlayers) {
    this.startPlayers = startPlayers;
  }

  public List<Player> getWaitPlayers() {
    return waitPlayers;
  }

  public void setWaitPlayers(List<Player> waitPlayers) {
    this.waitPlayers = waitPlayers;
  }

  /**
   * 添加球员
   *
   * @param player
   */
  public void addPlayer(Player player) {
    //先发阵容每个位置都有一个人
    waitPlayers.add(player);//直接添加到替补席
    //等会思考

  }

  /**
   * 调整首发名单(List<球员类>)
   *
   * @param list
   */
  public void replaceStartPlayers(List<Player> list) {  //  1~5

    //首先从替补中移除list里面的球员
    for (int i = 0; i < list.size(); i++) {
      if (waitPlayers.contains(list.get(i))) {
        waitPlayers.remove(list.get(i));  //从替补中移除
      }
    }
    for (int i = 0; i < list.size(); i++) { //  PG  SG
      for (int j = 0; j < startPlayers.size(); j++) { //
        if (list.get(i).getPosition().equals(startPlayers.get(j).getPosition())) {  //判断各个球员的司职
          //将首发球员添加到替补中去
          waitPlayers.add(startPlayers.get(j));  //将首发位置满足条件的添加到替补中
          startPlayers.remove(j);  //从首发移除  //移除首发位置的相应球员
          startPlayers.add(list.get(i)); //把换上去的球员添加到首发位置
          break;
        }
      }
    }
  }
  //接收一个球员类，从替补或首发移除该球员
  public void removePlayer(Player player) {
    if (waitPlayers.contains(player)) {
      waitPlayers.remove(player);
    }
    if (startPlayers.contains(player)) {
      startPlayers.remove(player);
    }
  }
  /*
	替换相同位置的球员，从替补位置，放置到首发位置
*/
  public void replacePlayer(Player player) {  //确定要上场的球员  根据这个球员去删除替补 和首发名单
    //当前首发打的位子和替补位置一样
    //替补球员里面可能有一个以上的重复位置  PG  PG
    for (int i = 0; i < waitPlayers.size(); i++) {
      if (waitPlayers.get(i).equals(player)) { //找替补中第一个出现的位置的球员
        //如果满足条件就表示在集合中第一次遇到相同条件的球员
        waitPlayers.remove(waitPlayers.get(i));
      }
    }

    //因为首发名单里面的每个人打的位置不一样 所以不用考虑位置重复问题
    for (int i = 0; i < startPlayers.size(); i++) {
      if (startPlayers.get(i).getPosition().equals(player.getPosition())) {
        waitPlayers.add(startPlayers.get(i));
        startPlayers.remove(startPlayers.get(i)); //首发移除的人 添加到替补中
      }
    }
    startPlayers.add(player);

  }

  public void print() {
    System.out.println("首发名单如下:");
    System.out.println(startPlayers);
    System.out.println("替补名单如下:");
    System.out.println(waitPlayers);
  }


}
