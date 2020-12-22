package hebei;

import jiangsu.Nanjing;

public class Shijiazhuang {

  private String priField = "shijiazhuang priField";
  String dField = "shijiazhuang dField";
  ;
  public String pField = "shijiazhuang pField";
  ;

  public void pMethod() {
    System.out.println("shijiazhuang pMethod");
  }

  void dMethod() {
    System.out.println("shijiazhuang dMethod");
  }

  private void priMethod() {
    System.out.println("shijiazhuang priMethod");
  }

  public static void main(String[] args) {
    ChengDe chengDe = new ChengDe();
    System.out.println(chengDe.dField);
    System.out.println(chengDe.pField);
    // 不能访问其他类的私有成员
    // System.out.println(chengDe.priField);
    chengDe.dMethod();
    chengDe.pMethod();
    // 私有方法也是不允许访问
    // chengDe.priMethod();

    Shijiazhuang shijiazhuang = new Shijiazhuang();
    System.out.println(shijiazhuang.dField);
    System.out.println(shijiazhuang.pField);
    // 类的内部方法中，可以直接访问当前类的对象的私有成员
    System.out.println(shijiazhuang.priField);

    Nanjing nanjing = new Nanjing();
    System.out.println(nanjing.pField);
    // 无法访问不同包下的  默认访问权限的成员
    // System.out.println(nanjing.dField);
    // System.out.println(nanjing.priField);
  }
}
