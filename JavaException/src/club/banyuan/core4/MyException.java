package club.banyuan.core4;

/**
 * @author sanye
 * @version 1.0
 * @date 2020/11/30 3:50 下午
 */
public class MyException   extends  RuntimeException{

  /**
   * 处理年龄异常
   *
   * 问:当前的异常信息能满足所有情况下的异常处理嘛？
   *    并不能
   *
   */
  public MyException() {
    super();
  }

  public MyException(String message) {
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
}
