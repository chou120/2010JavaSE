package q6;

import java.util.Objects;

public class WhenCatch {

  public static void main(String[] args) {

    // try {
    int byIndex = getByIndex(new int[3], 5);
    // } catch (NullPointerException e) {
    //   System.out.println("空指针");
    // } catch (IndexOutOfBoundsException e) {
    //   System.out.println("越界");
    // }
  }

  // 不能使用异常来代替参数检查
  // 检查到参数异常之后如何告知
  public static int getByIndex(int[] a, int index) {
    Objects.requireNonNull(a);

    // if (a == null) {
    //   throw new NullPointerException();
    //   // return 0;
    // }

    if (index < 0 || index > a.length) {
      return 0;
    }
    return a[index];
  }

  public static int[] getAIntArr(int len) {
    if (len < 0) {
      // throw new IndexOutOfBoundsException();
      return new int[0];
    } else {
      return new int[len];
    }
  }
}
