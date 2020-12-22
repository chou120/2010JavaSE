package club.banyuan;

public class PairDriver {

  /**
   * 创建几个体育场对，然后打印容量最大的体育场名称。
   */
  // @SuppressWarnings("unchecked")
  public static void main(String[] args) {

    OnePair<String, Integer>[] stadiums = new OnePair[3];
    stadiums[0] = new OnePair<>("五棵松", 25000);
    stadiums[1] = new OnePair<>("鸟巢", 109901);
    stadiums[2] = new OnePair<>("奥体中心", 66233);

    System.out.println(stadiums[0]);
  }

  /**
   * 返回容量最大的体育场的名称。
   *
   * @param stadiums ObjectPairs的数组，其中包含一个体育管名称，还有一个数字作为体育馆容量
   * @return 容量最大的体育馆的名称
   */
  public static String largestStadium(OnePair<String, Integer>[] stadiums) {
    if (stadiums == null || stadiums.length == 0) {
      return null;
    }
    int max = stadiums[0].getSecond();

    OnePair<String, Integer> max2 = stadiums[0];
    for (OnePair<String, Integer> stadium : stadiums) {
      if (max < stadium.getSecond()) {
        max = stadium.getSecond();
        max2 = stadium;
      }
    }

    return max2.getFirst();
  }

}