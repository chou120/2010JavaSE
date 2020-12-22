package club.banyuan.video;

import java.io.Serializable;

public class Video implements Serializable {
//- 片名
// - 是否被出租的标识
// - 用户的平均评分

  private String name;
  private boolean isRent;
  private int mark;
  private int markTimes;

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

  public void setMark(int mark) {
    this.mark = (this.mark * markTimes + mark) / (markTimes + 1);
    markTimes++;
  }


}
