package club.banyuan.innerDemo;

/**
 * @author sanye
 * @version 1.0
 * @date 2020/11/24 2:29 下午
 */
public class Outer {
  public  String name;


  public class Inner {  // 外部类名$内部类名.class
      public  void  method(){
        System.out.println("是撒火花塞");
      }
  }
}
class  Test{

  public static void main(String[] args) {
    new  Outer().new  Inner().method();
  }
}