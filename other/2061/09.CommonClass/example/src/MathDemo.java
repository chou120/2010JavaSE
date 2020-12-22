import java.util.Random;

public class MathDemo {

  public static void main(String[] args) {
    Math.min(1, 3);
    Math.max(2, 5);
    Math.abs(-3);

    // 随机生成 0~1之间的小数
    // from ~ to
    System.out.println(Math.random());

    Random rand = new Random();
    // 随机生成 [0,10) 之间的随机数
    System.out.println(rand.nextInt(10));

  }
}
