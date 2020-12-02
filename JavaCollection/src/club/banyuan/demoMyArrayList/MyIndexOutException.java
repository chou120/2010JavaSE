package club.banyuan.demoMyArrayList;

/**
 * @author sanye
 * @version 1.0
 * @date 2020/12/2 9:12 上午
 */
public class MyIndexOutException  extends   RuntimeException {

  public MyIndexOutException() {
    super();
  }

  public MyIndexOutException(String message) {
    super(message);
  }

  public MyIndexOutException(String message, Throwable cause) {
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
