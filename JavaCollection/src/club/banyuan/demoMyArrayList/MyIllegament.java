package club.banyuan.demoMyArrayList;

/**
 * @author sanye
 * @version 1.0
 * @date 2020/12/2 9:15 上午
 */
public class MyIllegament  extends  RuntimeException {

  public MyIllegament() {
    super();
  }

  public MyIllegament(String message) {
    super(message);
  }

  public MyIllegament(String message, Throwable cause) {
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
