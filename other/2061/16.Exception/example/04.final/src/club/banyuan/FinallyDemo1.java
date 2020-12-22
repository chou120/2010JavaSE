package club.banyuan;

public class FinallyDemo1 {

  public static void main(String[] args) throws Exception {
    test();
  }


  public static void test() {

    try {
      System.out.println("1");
      // return;
      throw new Exception();
    } catch (RuntimeException e) {
      System.out.println("2");
      // throw new RuntimeException();
    } finally {
      System.out.println("3");
      return; // finally里面return将会导致 准备抛出方法外部的异常被吃掉
    }

    // System.out.println("4");
  }
}
