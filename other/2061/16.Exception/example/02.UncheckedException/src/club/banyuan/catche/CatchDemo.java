package club.banyuan.catche;

public class CatchDemo {
  // Throwable

  // Error
  // Exception

  // RuntimeException

  // IllegalArgumentException
  // UnsupportedOperationException
  // IllegalStateException
  public static void main(String[] args) {
    // 对象 instanceof 类
    int i = 0;
    try {
      i = Integer.parseInt("a");
      String s = null;
      System.out.println(s.toUpperCase());
    } catch (NumberFormatException e) {
      System.out.println("数字格式错误");
      // e.printStackTrace();
    } catch (NullPointerException e) {
      System.out.println("空指针");
    } catch (RuntimeException e) {
      System.out.println("其他的运行时异常");
    } catch (Exception e) {

    }
    System.out.println("数字转换：" + i);
  }

}
