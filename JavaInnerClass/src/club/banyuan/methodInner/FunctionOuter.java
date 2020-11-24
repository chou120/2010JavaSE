package club.banyuan.methodInner;

/**
 * @author sanye
 * @version 1.0
 * @date 2020/11/24 3:14 下午
 */
public class FunctionOuter {

  private static int s = 100;
  private int s1 = 20;

  public Object print(final int param) {  //方法内部类
    final int in = 300;  //局部变量
    class FunctionInner {
      public void innerTest() {
        // in=param; //报错
        System.out.println("FunctionInner：s=" + s);
        System.out.println("FunctionInner：s1=" + s1);
        System.out.println("FunctionInner：in" + in);
        //param=123;
        System.out.println(param);
        test();
        info();
      }
//      public static  void method(){  报错
//      }
    }
    FunctionInner fi = new FunctionInner();
    fi.innerTest();
    //System.out.println("print:in"+in);
    return fi;
  }

  public static void info() {

  }

  public void test() {
    System.out.println("FunctionOuter：" + s);
  }

  public static void main(String[] args) {
    FunctionOuter fo = new FunctionOuter();
    Object print = fo.print(900);
    //FunctionInner  f=(FunctionInner)print;

  }


}
