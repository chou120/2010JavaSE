package club.banyuan.staticDemo11.gc;

/**
 * @author sanye
 * @version 1.0
 * @date 2020/11/19 2:03 下午
 */
public class MyFinalize {

  private String name;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Override
  protected void finalize() throws Throwable {
    super.finalize();
    System.out.println(name + "被当成垃圾回收了");
  }


}

class TestMyFinalize {

  public static void main(String[] args) {
    MyFinalize myFinalize = new MyFinalize();
    myFinalize.setName("张三");
    myFinalize = null;
    System.gc();

  }
}
