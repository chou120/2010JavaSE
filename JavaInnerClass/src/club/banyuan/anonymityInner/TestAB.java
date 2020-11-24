package club.banyuan.anonymityInner;

/**
 * @author sanye
 * @version 1.0
 * @date 2020/11/24 3:49 下午
 */
public class TestAB {

  public static void main(String[] args) {
    new  AB(){
      public  void  method(){
        System.out.println("哈是啥");
      }
    }.method();
  }

}
