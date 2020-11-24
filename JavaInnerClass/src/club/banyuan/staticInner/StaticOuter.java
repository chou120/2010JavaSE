package club.banyuan.staticInner;

/**
 * @author sanye
 * @version 1.0
 * @date 2020/11/24 2:42 下午
 */
public class StaticOuter {
  private static int shared = 100;
  private String  name="张三"; //

  public static class StaticInner{
    private  static  String  ADDRESS="没人";
    public  static void   method(){
    //static int age =12;
      System.out.println(ADDRESS+shared);
    }
    public void staticInnerMethod() {
      System.out.println("Static Inner Method" +shared);
    }
  }
}
class  TestMain{

  public static void main(String[] args) {
    StaticOuter.StaticInner  staticInner=new StaticOuter.StaticInner();
    //创建是内部类对象
    staticInner.staticInnerMethod();

    StaticOuter.StaticInner.method();


  }

}
