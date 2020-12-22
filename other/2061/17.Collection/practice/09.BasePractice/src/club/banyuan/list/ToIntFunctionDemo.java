package club.banyuan.list;

import club.banyuan.Player;
import club.banyuan.Position;
import java.util.function.ToIntFunction;

public class ToIntFunctionDemo {

  public static void main(String[] args) {
    ToIntFunction<Player> toIntFunction = value -> {
      return getStaticNum(value);
      // return value.getNum();
      // return value.getNum();
    };

    // return value.getNum();
    // return value.getNum();
    ToIntFunction<Player> toIntFunction1 = ToIntFunctionDemo::getStaticNum;

    // int applyAsInt (Player value) =>Player::getNum()
    // ToIntFunctionDemo::getStaticNum;

    toIntFunction.applyAsInt(new Player("1", Position.C, 22));
  }

  public static int getStaticNum(Player player) {
    return player.getNum();
  }
}
