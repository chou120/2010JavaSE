package club.banyuan.core4;

/**
 * @author sanye
 * @version 1.0
 * @date 2020/11/30 3:52 下午
 */
public class MyExceptionScore  extends  RuntimeException {

  public MyExceptionScore() {
    super();
  }

  public MyExceptionScore(String message) {
    super(message);
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

  @Override
  public void printStackTrace() {
    super.printStackTrace();
  }
}
