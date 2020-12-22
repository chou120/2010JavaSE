package club.banyuan;

public class ScannerRuleImpl implements ScannerRule {

  @Override
  public boolean validate(String s) {
    int input = Integer.parseInt(s);
    return input > 0 && input < 10;
  }

  @Override
  public void doWhenError() {
    System.out.println("输入不合法，请输入0~10之间的数字");
  }
}
