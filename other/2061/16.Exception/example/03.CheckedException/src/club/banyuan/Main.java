package club.banyuan;

public class Main {

  // 如果调用方法引起的异常和调用方有关系，错误由调用方引起的，这种情况抛出运行时异常，非受查异常
  // 由于方法内部依赖的其他方法出现故障导致的异常，抛出受查异常
  public static void main(String[] args) {
    // 受查异常强制要求必须捕获异常，如果不处理，需要在调用的方法上增加throws声明
    try {
      throwCheckedException();
    } catch (CheckedException e) {
      e.printStackTrace();
    }

    // 运行时异常可以不强制要求捕获异常
    throwUncheckedException();
  }


  public static void throwCheckedException() throws CheckedException {
    throw new CheckedException("受查异常");
  }

  public static void throwUncheckedException() throws UncheckedException {
    throw new UncheckedException("运行时异常");
  }
}
