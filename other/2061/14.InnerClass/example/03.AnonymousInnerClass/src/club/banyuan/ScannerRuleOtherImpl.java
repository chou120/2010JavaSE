package club.banyuan;

public class ScannerRuleOtherImpl implements ScannerRule {

  @Override
  public boolean validate(String s) {
    switch (s) {
      case "a":
      case "b":
      case "c":
      case "d":
        return true;
      default:
        return false;
    }
  }

  @Override
  public void doWhenError() {
    System.out.println("输入不合法，请输入 a,b,c,d");
  }
}
