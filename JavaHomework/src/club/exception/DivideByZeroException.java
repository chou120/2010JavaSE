package club.exception;

/**
 * @author sanye
 * @version 1.0
 * @date 2020/11/30 4:54 下午
 */
public class DivideByZeroException extends  CalculatorException{

//  @Override
//  public String getMessage() {
//    return "Tried to divide by zero ";
//  }
//


  public DivideByZeroException() {
    super();
  }

  public DivideByZeroException(String message) {
    super(message);
  }

  public DivideByZeroException(String message, Throwable cause) {
    super(message, cause);
  }

  @Override
  public String getMessage() {
    return super.getMessage();
  }

  @Override
  public synchronized Throwable getCause() {
    return super.getCause();
  }

  @Override
  public String toString() {
    return super.toString();
  }
}
