package club.exception;

import club.banyuan.doc15_2.E;

/**
 * @author sanye
 * @version 1.0
 * @date 2020/11/30 4:51 下午
 */
public class IllegalInputException extends CalculatorException {
  public IllegalInputException() {
  }

  public IllegalInputException(String message) {
    super(message);
  }

  public IllegalInputException(String message, String exceptionType) {
    super(message + exceptionType);
  }


  public IllegalInputException(String message, Throwable cause) {
    super(message, cause);
  }

  public IllegalInputException(Throwable cause) {
    super(cause);
  }

  public IllegalInputException(String message, Throwable cause, boolean enableSuppression,
      boolean writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);
  }
}
