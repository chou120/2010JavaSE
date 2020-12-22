package club.banyuan;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

// InputStream  OutputStream 字节流 byte
//                           字符流 char
public class ReaderDemo {

  public static void main(String[] args) {
    try (Reader reader = new FileReader(
        "/Users/liyi/works/repos/banyuan/javase-2061/19.IO/example/text");
        Writer writer = new FileWriter(
            "/Users/liyi/works/repos/banyuan/javase-2061/19.IO/example/out.txt")
    ) {
      // 读取一个char字符，转换成int，读取到-1，表示读取结束
      // int read = reader.read();

      char[] buf = new char[1024];
      int count = reader.read(buf);
      System.out.println(count);
      System.out.println(new String(buf, 0, count));

      writer.append("你").append("好").append("吗").append("?");
    } catch (IOException e) {
      e.printStackTrace();
    }

  }
}
