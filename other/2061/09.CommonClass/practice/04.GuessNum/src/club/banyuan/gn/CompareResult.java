package club.banyuan.gn;

public class CompareResult {

  // 位置正确的个数
  private int posCorrect;

  // 数字正确
  private int numCorrect;

  public CompareResult(int posCorrect, int numCorrect) {
    this.posCorrect = posCorrect;
    this.numCorrect = numCorrect;
  }

  // 包含了1个正确的数字
  // 这些数字位置错误

  // 包含了3个正确的数字
  // 2个数字位置正确
  public void printInfo() {
    System.out.println("包含了" + numCorrect + "个正确的数字");
    if (posCorrect == 0) {
      System.out.println("这些数字位置错误");
    } else {
      System.out.println(posCorrect + "个数字位置正确");
    }
  }

  public boolean isCorrect() {
    return posCorrect == 4;
  }
}
