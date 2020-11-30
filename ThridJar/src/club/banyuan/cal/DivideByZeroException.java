package club.banyuan.cal;

public class DivideByZeroException extends CalculatorException {

  @Override
  public String getMessage() {
    return "Tried to divide by zero ";
  }
}
