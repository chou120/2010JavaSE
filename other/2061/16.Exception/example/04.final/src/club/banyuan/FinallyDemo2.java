package club.banyuan;

public class FinallyDemo2 {

  public static void main(String[] args) throws Exception {
    System.out.println(test());
  }


  public static int test() {

    int a = 5;
    try {
      System.out.println("1");
      return a;
    } catch (RuntimeException e) {
      System.out.println("2");
      // throw new RuntimeException();
    } finally {
      System.out.println("3");
      a++;
      // return a;
    }
    return a;

    // System.out.println("4");
  }

  public static int test1() {

    int a = 5;
    try {
      System.out.println("1");
      throw new RuntimeException();
      // return a;
    } catch (RuntimeException e) {
      System.out.println("2");
      // throw new RuntimeException();
    } finally {
      System.out.println("3");
      a++;
      // return;
    }
    return a;

    // System.out.println("4");
  }
}
