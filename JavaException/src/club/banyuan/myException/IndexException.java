package club.banyuan.myException;

/**
 * @author sanye
 * @version 1.0
 * @date 2020/11/30 4:05 下午
 */
public class IndexException  extends  RuntimeException {

  public IndexException() {
    super();
  }

  public IndexException(String message) {
    super(message);
  }

  public IndexException(String message, Throwable cause) {
    super(message, cause);
  }

  public IndexException(Throwable cause) {
    super(cause);
  }

  protected IndexException(String message, Throwable cause, boolean enableSuppression,
      boolean writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);
  }
}
