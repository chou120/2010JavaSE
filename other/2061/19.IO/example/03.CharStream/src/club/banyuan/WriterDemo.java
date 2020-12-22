package club.banyuan;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

// InputStream  OutputStream 字节流 byte
//                           字符流 char
public class WriterDemo {

  public static void main(String[] args) {
    try (
        Writer writer = new FileWriter(
            "/Users/liyi/works/repos/banyuan/javase-2061/19.IO/example/out.txt",true)
    ) {
      // append 会返回一个Writer，因此可以使用链式的写法，连续调用
      writer.append("你").append("好").append("吗").append("?");
      // writer.write('\n');
      // 输入一个换行符
      writer.write(System.lineSeparator());
      writer.write("123呵呵");
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
