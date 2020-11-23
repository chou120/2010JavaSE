package club.banyuan.playJoker;

/**
 * @author sanye
 * @version 1.0
 * @date 2020/11/21 10:50 上午
 */
public class TestJoker {

  public static void main(String[] args) {
    Player player1 = new Player();
    player1.setName("李熠");
    Player player2 = new Player();
    player2.setName("林川");
    Player player3 = new Player();
    player3.setName("老周");

    String[] strings = Joker.randomJoker();
    //确定地主
    int index = (int) (Math.random() * strings.length-3);
    String str = strings[index];  //地主标志的牌

    for (int i = 0; i < strings.length - 3; i++) {
      if (i % 3 == 0) {
        if (strings[i].equals(str)) {
          player1.setFlag(true);
        }
        player1.addJoker(strings[i]);
      } else if (i % 3 == 1) {
        if (strings[i].equals(str)) {
          player2.setFlag(true);
        }
        player2.addJoker(strings[i]);
      } else if (i % 3 == 2) {
        if (strings[i].equals(str)) {
          player3.setFlag(true);
        }
        player3.addJoker(strings[i]);
      }
    }
    //地主抓底牌
    for (int i = strings.length - 3; i < strings.length; i++) {
      if (player1.isFlag()) {
        player1.addJoker(strings[i]);
      }
      if (player2.isFlag()) {
        player2.addJoker(strings[i]);
      }
      if (player3.isFlag()) {
        player3.addJoker(strings[i]);
      }
    }

    //输出每个玩家的牌面
    System.out.println(player1);
    System.out.println(player2);
    System.out.println(player3);




  }
}
