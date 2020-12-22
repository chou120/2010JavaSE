package club.banyuan.simulation;

public class FridgeFullException extends RuntimeException {

  public FridgeFullException() {
  }

  public FridgeFullException(String message) {
    super(message);
  }

  public FridgeFullException(String message, Throwable cause) {
    super(message, cause);
  }

  public FridgeFullException(Throwable cause) {
    super(cause);
  }

  public FridgeFullException(String message, Throwable cause, boolean enableSuppression,
      boolean writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);
  }
}
