package club.exception;

/**
 * @author sanye
 * @version 1.0
 * @date 2020/11/30 4:50 下午
 */
public class QuitException extends CalculatorException {

  public QuitException() {
  }

  public QuitException(String message) {
    super(message);
  }

  public QuitException(String message, Throwable cause) {
    super(message, cause);
  }

  public QuitException(Throwable cause) {
    super(cause);
  }

  public QuitException(String message, Throwable cause, boolean enableSuppression,
      boolean writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);
  }

}