package club.banyuan;

public class Main {

  public static void main(String[] args) {
    // ScanInput.scanInput(new ScannerRuleImpl());
    // ScanInput.scanInput(new ScannerRuleOtherImpl());

    ScanInput.scanInput(new ScannerRule() {
      @Override
      public boolean validate(String s) {
        switch (s) {
          case "0":
          case "1":
            return true;
          default:
            return false;
        }
      }

      @Override
      public void doWhenError() {
        System.out.println("请输入0或1");
      }
    });
  }
}
