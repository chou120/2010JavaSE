package q7;

class M {

  int i;

  public M(int i) {
    this.i = i--;
  }
}

class N extends M {

  public N(int i) {
    super(++i);

    System.out.println(i);
  }
}

public class MainClass {

  public static void main(String[] args) {
    N n = new N(26);
    System.out.println(n.i);
  }
}