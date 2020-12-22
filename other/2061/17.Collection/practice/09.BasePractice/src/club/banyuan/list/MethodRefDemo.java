package club.banyuan.list;

import club.banyuan.Player;
import java.util.function.ToIntFunction;

public class MethodRefDemo {

  public static void main(String[] args) {
    // 构成方法引用的写法，重写函数式接口的方法
    // 重写方法只有一句话，一句话是调用了另一个方法。
    // 引用实例方法，重写方法的入参的第一个参数，作为实例方法的调用对象。其他的参数作为引用方法的参数按照顺序传入
    ToIntFunction<Player> toIntFunction = Player::getNum;

    // 引用静态方法，重写方法的入参作为静态方法的入参使用。
    ToIntFunction<Player> toIntFunction1 = ToIntFunctionDemo::getStaticNum;

    // 引用构造方法，重写方法的入参，作为构造方法的入参使用。
    PlayerCreate create = Player::new;
  }
}
