package club.banyuan.video;

import com.alibaba.fastjson.JSONObject;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class VideoStore implements Serializable {

  public static final String MAX_VIDEO = "max.video";
  public static final String STORE_FILE_PATH = "store.file.path";
  private Video[] videos = new Video[10];
  private int count;

  public Video[] getVideos() {
    return videos;
  }

  public void setVideos(Video[] videos) {
    this.videos = videos;
  }

  public int getCount() {
    return count;
  }

  public void setCount(int count) {
    this.count = count;
  }

  // 从文件加载内容
  public static VideoStore load() {
    String filePath = PropUtil.getProp(STORE_FILE_PATH);
    try (InputStream inputStream = new FileInputStream(filePath)) {

      return JSONObject
          .parseObject(inputStream, StandardCharsets.UTF_8, VideoStore.class);


    } catch (IOException e) {
      e.printStackTrace();
    }
    return new VideoStore();
  }


  public void save() {
    String filePath = PropUtil.getProp(STORE_FILE_PATH);
    try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
      writer.write(JSONObject.toJSONString(this));
      writer.flush();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }


  public static VideoStore loadObj() {
    String filePath = PropUtil.getProp(STORE_FILE_PATH);
    try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(filePath))) {
      return (VideoStore) inputStream.readObject();

    } catch (IOException | ClassNotFoundException e) {
      e.printStackTrace();
    }
    return new VideoStore();
  }

  public void saveObj() {
    String filePath = PropUtil.getProp(STORE_FILE_PATH);
    try (ObjectOutputStream writer = new ObjectOutputStream(new FileOutputStream(filePath))) {
      writer.writeObject(this);
      writer.flush();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  /**
   * 添加一个新的电影
   * 通过电影的名称创建一个video对象，将对象保存在数组中
   *
   * @param name 电影的名称
   */
  public void addVideo(String name) {
    int max = PropUtil.getIntProp(MAX_VIDEO);
    if (count > max) {
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

  /**
   * 列出整个库存的电影。
   * 电影名称  是否被借出   平均评分
   */
  public void listInventory() {
    for (int i = 0; i < count; i++) {
      String rentMsg = "没有被借出";
      if (videos[i].isRent()) {
        rentMsg = "已被借出";
      }
      System.out.println("电影名称是" + videos[i].getName() + rentMsg + "平均评分为" + videos[i].getMark());
    }
  }

  // public static void main(String[] args) {
  //   VideoStore videoStore = new VideoStore();
  //   videoStore.addVideo("黑客帝国");
  //   videoStore.addVideo("教父");
  //   videoStore.addVideo("沉默的羔羊");
  //   videoStore.listInventory();
  //   videoStore.checkOut("教父");
  //   videoStore.listInventory();
  //   videoStore.returnVideo("教父");
  //   videoStore.receiveRating("教父", 4);
  //   videoStore.listInventory();
  //
  // }

  public void addVideo() {
    System.out.println("要添加的电影名称：");
    Scanner scanner = new Scanner(System.in);
    String videoName = scanner.nextLine();
    addVideo(videoName);
    saveObj();
    System.out.println("操作成功");
  }

  // TODO 借出电影
  public void checkOut() {

  }

  // TODO 归还电影
  public void returnVideo() {

  }


  public static void main(String[] args) throws IOException {
    File file = new File("~/Desktop/123.txt");

    System.out.println(file.getAbsolutePath());
    // FileOutputStream fileOutputStream = new FileOutputStream("~/Desktop/123.txt");
    // fileOutputStream.write(1);
    // fileOutputStream.close();
    // try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("~/Desktop/123.txt")))) {
    //   writer.write(JSONObject.toJSONString(new Object()));
    //   writer.flush();
    // } catch (IOException e) {
    //   e.printStackTrace();
    // }
  }
}
