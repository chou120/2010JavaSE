package q16;

class Alpha {

  static String s = " ";

  protected Alpha() {
    s += "alpha ";
  }
}

class SubAlpha extends Alpha {

  private SubAlpha() {
    s += "sub ";
  }

}

public class SubSubAlpha extends Alpha {

  private SubSubAlpha() {
    s += "subsub ";
  }

  public static void main(String[] args) {
    new SubSubAlpha();
    System.out.println(s);
    // 编译报错，在其他类中无法创建SubAlpha的对象，因为构造方法私有化
    // new SubAlpha();
  }
} 