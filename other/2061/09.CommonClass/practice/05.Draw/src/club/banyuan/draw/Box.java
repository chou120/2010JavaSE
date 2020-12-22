package club.banyuan.draw;

import java.util.Random;

public class Box {

  // |大吉 | 中吉 | 小吉 | 吉 | 末吉 | 凶  | 大凶 |
  //     | ----|----|----|----|----|----|---- |
  //     | 5% | 10% | 15% | 30% | 20% | 15% | 5%|
  private Lot[] lots = new Lot[]{
      new Lot("大吉", 5),
      new Lot("中吉", 10),
      new Lot("小吉", 15),
      new Lot("吉", 30),
      new Lot("末吉", 20),
      new Lot("凶", 15),
      new Lot("大凶", 5),
  };

  public String draw() {
    String[] draw = new String[100];
    int index = 0;
    for (Lot lot : lots) {
      for (int i = 0; i < lot.getRate(); i++) {
        draw[index] = lot.getName();
        index++;
      }
    }

    Random random = new Random();
    int drawIndex = random.nextInt(100);
    return draw[drawIndex];
  }
}
