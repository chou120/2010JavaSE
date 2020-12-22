package club.banyuan.simulation;

public class FridgeGateStateException extends RuntimeException {

  public FridgeGateStateException() {
  }

  public FridgeGateStateException(String message) {
    super(message);
  }

  public FridgeGateStateException(String message, Throwable cause) {
    super(message, cause);
  }

  public FridgeGateStateException(Throwable cause) {
    super(cause);
  }

  public FridgeGateStateException(String message, Throwable cause, boolean enableSuppression,
      boolean writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);
  }
}
