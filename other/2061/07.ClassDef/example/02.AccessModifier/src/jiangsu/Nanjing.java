package jiangsu;

import hebei.ChengDe;
import hebei.Shijiazhuang;

public class Nanjing {

  private String priField = "nanjing priField";
  String dField = "nanjing dField";
  public String pField = "nanjing pField";

  public void pMethod() {
    System.out.println("nanjing pMethod");
  }

  void dMethod() {
    System.out.println("nanjing dMethod");
  }

  private void priMethod() {
    System.out.println("nanjing priMethod");
  }

  public static void main(String[] args) {
    ChengDe chengDe = new ChengDe();
    // System.out.println(chengDe.dField); // 编译报错
    System.out.println(chengDe.pField);
    // 不能访问其他类的私有成员
    // System.out.println(chengDe.priField);
    // chengDe.dMethod();
    chengDe.pMethod();
    // 私有方法也是不允许访问
    // chengDe.priMethod();

    Shijiazhuang shijiazhuang = new Shijiazhuang();
    // System.out.println(shijiazhuang.dField);
    System.out.println(shijiazhuang.pField);
    // System.out.println(shijiazhuang.priField);

    Nanjing nanjing = new Nanjing();
    System.out.println(nanjing.pField);
    System.out.println(nanjing.dField);
    System.out.println(nanjing.priField);
  }
}
