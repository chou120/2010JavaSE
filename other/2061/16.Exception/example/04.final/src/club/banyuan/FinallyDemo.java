package club.banyuan;

public class FinallyDemo {

  public static void main(String[] args) {
    test();
  }


  public static void test() {

    try {
      System.out.println("1");
      // return;
      throw new RuntimeException();
    } catch (RuntimeException e) {
      System.out.println("2");
      // throw  new RuntimeException();
    } finally {
      System.out.println("3");
    }

    System.out.println("4");
  }
}
