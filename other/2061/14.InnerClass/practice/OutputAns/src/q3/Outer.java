package q3;

class Outer {

  String s1 = "Java";
  String s2 = "2";

  public static void main(String[] args) {
    Outer outer = new Outer();
  }

  Outer() {
    Inner inner = new Inner();
  }

  class Inner {

    //String s1 = "Certification";
    String s2 = "Exam";

    Inner() {
      System.out.println(Outer.this.s1);
      // System.out.println(this.s1);  // 编译报错，因为内部类中没有定义这个成员变量
      System.out.println(s1); // Outer.this.s1

      System.out.println(s2); // this.s2
    }
  }
}