package club.banyuan.video;

import java.util.Scanner;

public class Main {

  // TODO
  // 实现剩余功能
  // 如果path里面配置的文件夹不存在，创建对应的文件夹
  // 数组换为List实现功能
  // 使用ObjectIO stream 重写load 和 save 可选
  // video.properties 配置一个video保存的最大数量，不允许添加超过改数量的影片总数 可选

  // video 的数据，保存到文件中
  // 保存文件的路径，是可配置的
  // 菜单，为电影添加、删除、评分
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    VideoStore videoStore = VideoStore.loadObj();

    while (true) {
      videoStore.listInventory();
      System.out.println("=======");
      System.out.println("1.添加");
      System.out.println("2.借出");
      System.out.println("3.归还");
      System.out.println("0.退出");
      System.out.println("=======");
      String s = scanner.nextLine();

      switch (s) {
        case "1":
          videoStore.addVideo();
          break;
        case "2":
          videoStore.checkOut();
          break;
        case "3":
          videoStore.returnVideo();
          break;
        case "0":
          System.out.println("退出");
          return;
        default:
          break;
      }
    }

  }

}
