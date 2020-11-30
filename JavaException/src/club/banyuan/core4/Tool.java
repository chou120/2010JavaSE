package club.banyuan.core4;

/**
 * @author sanye
 * @version 1.0
 * @date 2020/11/30 3:54 下午
 */
public class Tool {

  private Tool() {

  }


  public static String checkScore(int number) throws MyExceptionScore {
    if (number < 0 || number > 150) {  //Exception  运行时和非运行时
      throw new MyExceptionScore("分数为负数或者分数超过范围...");
    } else {
      return "优秀";
    }
  }

  public static void checkAge(int age) throws  MyException {
      if (age < 0 || age > 130) {
        throw new MyException("年龄不合法...");
      }
      //业务逻辑写完
  }
}

class Test {

  public static void main(String[] args) {
    try {
      Tool.checkAge(-1);
    } catch (MyException e) {
      System.out.println("------>" + e.getMessage());
    }
    System.out.println("后main程序执行不...");

  }
}