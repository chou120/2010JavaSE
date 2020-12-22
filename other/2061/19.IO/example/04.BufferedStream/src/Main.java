import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class Main {

  public static void main(String[] args) throws FileNotFoundException {

    try (InputStream inputStream = new FileInputStream(
        "/Users/liyi/works/repos/banyuan/javase-2061/19.IO/doc/WIN.mp3");

        MyBufferedInputStream bufferedStream = new MyBufferedInputStream(inputStream);
        OutputStream outputStream = new FileOutputStream(
            "/Users/liyi/works/repos/banyuan/javase-2061/19.IO/example/copy1.mp3")
    ) {
      long start = System.currentTimeMillis();
      int one = bufferedStream.read();
      while (one != -1) {
        outputStream.write(one);
        one = inputStream.read();
      }
      System.out.println("耗费时间：" + (System.currentTimeMillis() - start));
    } catch (Exception e) {
      e.printStackTrace();
    }


  }
}
