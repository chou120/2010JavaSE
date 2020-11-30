package club.exception;

/**
 * @author sanye
 * @version 1.0
 * @date 2020/11/30 4:54 下午
 */
public class DivideByZeroException extends  CalculatorException{
  @Override
  public String getMessage() {
    return "Tried to divide by zero ";
  }
}
