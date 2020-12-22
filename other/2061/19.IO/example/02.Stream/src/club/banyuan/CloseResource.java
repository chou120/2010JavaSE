package club.banyuan;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class CloseResource {

  public static void main(String[] args) {
    String from = "/Users/liyi/works/repos/banyuan/javase-2061/19.IO/doc/WIN.mp3";
    String to = "/Users/liyi/works/repos/banyuan/javase-2061/19.IO/example/copy.mp3";

    // 为了保证finally里面可以使用到这两个变量，必须把变量定义在try-finally代码块外部
    // 并且为了保证使用的时候变量被赋值，需要赋值null
    InputStream inputStream = null;
    OutputStream outputStream = null;
    try {

      inputStream = new FileInputStream(from);
      outputStream = new FileOutputStream(to);

      byte[] buf = new byte[1024];
      int count = inputStream.read(buf);

      while (count > 0) {
        outputStream.write(buf, 0, count);
        count = inputStream.read(buf);
      }

    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      // 流在使用完毕后，必须调用close方法，关闭资源，减少内存占用
      try {
        if (inputStream != null) {
          inputStream.close();
        }
      } catch (IOException e) {
        e.printStackTrace();
      }

      try {
        if (outputStream != null) {
          outputStream.close();
        }
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }
}
