package club.banyuan.list;

import club.banyuan.Player;
import club.banyuan.Position;
import java.util.ArrayList;
import java.util.List;

public class ListDemo {

  public static void main(String[] args) {
    List<Player> list = new ArrayList<>();

    list.add(new Player("A", Position.C, 11));
    list.add(new Player("B", Position.SF, 22));
    list.add(new Player("C", Position.PF, 33));
    list.add(new Player("D", Position.PG, 44));
    list.add(new Player("E", Position.SG, 55));

    // 查找，排序，修改，添加或移除
    Player temp;
    for (Player player : list) {
      if (player.getPosition() == Position.C) {
        temp = player;
      }
    }


  }
}
