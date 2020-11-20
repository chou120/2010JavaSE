package club.banyuan.video;

public class VideoStore {

  private Video[] videos = new Video[10];
  private int count;

  /**
   * 添加一个新的电影
   * 通过电影的名称创建一个video对象，将对象保存在数组中
   *
   * @param name 电影的名称
   */
  public void addVideo(String name) {
    if (count > 10) {
      System.out.println("装不下");
      return;
    }
    Video v1 = new Video();
    v1.setName(name);
    videos[count] = v1;
    count++;
  }

  /**
   * 根据片名借出电影
   *
   * @return 成功借出电影，返回true,如果片名不存在，则返回false
   */
  public boolean checkOut(String videoName) {
    Video video = findVideoByName(videoName);
    if (video != null) {
      return video.setRent(true);
    }
    return false;
  }
  /**
   * 归还电影
   *
   * @return 成功归还电影，返回true,如果片名不存在，则返回false
   */
  public boolean returnVideo(String videoName) {
    Video video = findVideoByName(videoName);
    if (video != null) {
      return video.setRent(false);
    }
    return false;
  }

  /**
   * 根据 电影名称查询电影
   *
   * @param videoName
   * @return 匹配到的电影，如果找不到对应名称的电影，返回null
   */
  private Video findVideoByName(String videoName) {
    for (int i = 0; i < count; i++) {
      if (videos[i].getName() == videoName) {
        return videos[i];
      }
    }
    System.out.println("没有这个电影：" + videoName);
    return null;
  }

  /**
   * 设置用户对电影的评分(1~5)，收到评分之后，计算该电影的平均评分，
   */
  public void receiveRating(String videoName, int mark) {
    Video videoByName = findVideoByName(videoName);
    if (videoByName != null) {
      videoByName.setMark(mark);
    }
  }

  public void listInventory() {
    for (int i = 0; i < count; i++) {
      String rentMsg = "没有被借出";
      if (videos[i].isRent()) {
        rentMsg = "已被借出";
      }
      System.out.println("电影名称是" + videos[i].getName() + rentMsg + "平均评分为" + videos[i].getMark());
    }
  }

  public static void main(String[] args) {
    VideoStore videoStore = new VideoStore();
    videoStore.addVideo("黑客帝国");
    videoStore.addVideo("教父");
    videoStore.addVideo("沉默的羔羊");
    videoStore.listInventory();
    videoStore.checkOut("教父");
    videoStore.listInventory();
    videoStore.returnVideo("教父");
    videoStore.receiveRating("教父", 4);
    videoStore.listInventory();

  }
}
