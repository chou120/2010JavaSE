package club.banyuan;

// 自定义运行时异常类，继承RuntimeException
public class MyRuntimeException extends RuntimeException {

  public MyRuntimeException() {
  }

  public MyRuntimeException(String message) {
    super(message);
  }

  public MyRuntimeException(String message, Throwable cause) {
    super(message, cause);
  }

  public MyRuntimeException(Throwable cause) {
    super(cause);
  }

  public MyRuntimeException(String message, Throwable cause, boolean enableSuppression,
      boolean writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);
  }
}
