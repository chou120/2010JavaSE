package club.banyuan.cal;

public class IllegalInputException extends CalculatorException {

  public static final String TOKEN_LEN = "Illegal Token Length";
  public static final String ARGUMENT = "Illegal Argument";
  public static final String OPERATOR = "Illegal Operator";
  public static final String INPUT = "Illegal input :";

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
