package club.banyuan;

public interface ScannerRule {

  // 检测输入是否合法的方法
  boolean validate(String s);

  // 如果不合法你应该怎么做
  void doWhenError();
}
