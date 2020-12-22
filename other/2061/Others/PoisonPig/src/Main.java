import java.util.Random;

public class Main {

  static boolean[] bucket = new boolean[1000];

  public static void main(String[] args) {
    int index = new Random().nextInt(1000);
    bucket[index] = true;
    System.out.println("index=" + index);

    Pig[] pigs = new Pig[8];
    for (int i = 0; i < pigs.length; i++) {
      pigs[i] = new Pig();
    }

    // int times = 0;

    for (int times = 0; times < 4; times++) {

      // 给对应编号的猪喂水
      for (int i = times * 250; i < (times + 1) * 250; i++) {
        String s = Integer.toBinaryString(i % 250);
        while (s.length() < 8) {
          s = "0" + s;
        }
        char[] chars = s.toCharArray();

        for (int i1 = 0; i1 < chars.length; i1++) {
          if (chars[i1] == '1') {
            pigs[i1].drink(bucket[i]);
          }
        }
      }
      // 判断猪是否存活，生成判断结果
      String rlt = "";
      boolean isFind = false;
      for (int i = pigs.length - 1; i >= 0; i--) {
        if (pigs[i].isAlive) {
          rlt = "0" + rlt;
        } else {
          rlt = "1" + rlt;
          isFind = true;
        }
      }
      if (isFind) {
        System.out.println(rlt);
        System.out.println("这水有毒：" + (Integer.parseInt(rlt, 2) + times * 250));
        break;
      }
    }

    // System.out.println(rlt);
    // int num = Integer.parseInt(rlt, 2);
    // System.out.println(num);

    // System.out.println(Integer.toBinaryString(200));

    // System.out.println(String.format("%08d", 0));
  }
}
