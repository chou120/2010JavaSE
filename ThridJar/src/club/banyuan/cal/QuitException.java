package club.banyuan.cal;

public class QuitException extends CalculatorException {

  private static final String QUITING_MSG = "Quitting\n"
      + "Thanks!";

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

  @Override
  public String getMessage() {
    return QUITING_MSG;
  }
}
