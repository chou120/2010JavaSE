public class GetMaxNum {

  // 快速生成main方法 psvm  或main
  public static void main(String[] args) {
    // sout tab或回车，快速生成打印语句
    System.out.println(getMaxNum(1, 2, 3));
    System.out.println(getMaxNum(5, 2, 3));
    System.out.println(getMaxNum(5, 3, 4));

  }

  // cmd + alt + l 格式化代码

  /**
   * 获取三个数中最大的数
   */
  static int getMaxNum(int a, int b, int c) {
    int max = a;
    if (max < b) {
      max = b;
    }
    if (max < c) {
      max = c;
    }

    return max;
  }
}


