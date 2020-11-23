package club.banyuan.stack;

import java.util.Queue;

/**
 * @author sanye
 * @version 1.0
 * @date 2020/11/21 3:21 下午
 */
public class Test {

  public static void main(String[] args) {
    final LinkedStack linkedStack = new LinkedStack();
    linkedStack.push(123);
    linkedStack.push("张三丰");
    linkedStack.push("张2丰");
    linkedStack.push("张1丰");
    linkedStack.push("张0丰");

    System.out.println(linkedStack.toString());

  }

}
