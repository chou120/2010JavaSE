import java.io.File;
import java.io.IOException;

public class ParentFile {

  public static void main(String[] args) throws IOException {
    File file = new File("/Users/liyi/works/repos/banyuan/javase-2061/19.IO/example");

    File subFile = new File(file, "test");

    subFile.createNewFile();
    subFile.mkdir();
  }
}
