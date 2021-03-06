package club.banyuan.video;

public class Video {
//- 片名
// - 是否被出租的标识
// - 用户的平均评分
  private String name;  //电影用户名
  private boolean isRent;  //是否被借出
  private int mark;//用户的平均评分     // 每个人的评分+   /本电影被评次数
  private int markTimes; //用户评分次数

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public boolean isRent() {
    return isRent;
  }

  public boolean setRent(boolean rent) {
    if (rent == isRent) {
      System.out.println("电影状态不对");
      if (isRent) {
        System.out.println("电影已经被借出");
      } else {
        System.out.println("电影未被借出");
      }
      return false;
    }
    isRent = rent;
    System.out.println("操作成功");
    return true;
  }

  public int getMark() {
    return mark;
  }

  public int getMarkTimes() {
    return markTimes;
  }

  public void setMarkTimes(int markTimes) {
    this.markTimes = markTimes;
  }

  //计算评分的方法
  public void setMark(int mark) {
    //平均分*评分次数 + 新用户评分  第一个人评分的时候    5    5     平均分*次数=总分  + 新分数    /新的次数  =新的平均分
    // 第二个人    4
    this.mark = (this.mark * markTimes + mark) / (markTimes + 1);
    markTimes++;  //
  }
}
