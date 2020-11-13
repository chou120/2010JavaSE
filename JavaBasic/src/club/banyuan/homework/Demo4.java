package club.banyuan.homework;

/**
 * @author sanye
 * @version 1.0
 * @date 2020/11/13 2:06 下午
 */
public class Demo4 {

  /**
   * 4.100到200之间找出能被5或6整除，但不能被两者同时整除的数
   */
  public static void main(String[] args) {
    for (int i = 100; i < 200; i++) {
      if(i%5==0&&i%6==0){
        continue;
      }
      if(i%5==0||i%6==0){
        System.out.println(i);
      }
    }
  }
}
