import java.io.File;
import java.io.IOException;

public class PathDemo {

  public static void main(String[] args) throws IOException {
    // 相对于工作路径， java 启动时所处的命令行的路径，工作路径
    File file = new File("");
    System.out.println(file.getAbsolutePath());
    System.out.println(file.getCanonicalPath());

  }
}
