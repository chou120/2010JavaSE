package q8;

class M {

  int i = 51;

  public M(int j) {
    System.out.println(i); // 51
    this.i = j * 10; // i=260
  }
}

class N extends M {

  // int i;
  public N(int j) {
    super(j);
    System.out.println(i); // 260
    // 如果子类中没有定义i，子类内部的i、this.i 和super.i指代了同一块内存区域
    // 如果子类中定义了i，这是在子类内部 i 和this.i 指代了同一块内存区域 和super.i 指代的内存区域不同
    this.i = j * 20; // 520
    super.i = j * 10;
  }
}

public class MainClass {

  public static void main(String[] args) {
    N n = new N(26);

    System.out.println(n.i);
  }
}