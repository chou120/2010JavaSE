import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class BufferedDemo {

  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new FileReader(
        "/Users/liyi/works/repos/banyuan/javase-2061/19.IO/example/03.CharStream/src/club/banyuan/ReaderDemo.java"));

    BufferedWriter writer = new BufferedWriter(
        new FileWriter("/Users/liyi/works/repos/banyuan/javase-2061/19.IO/example/bak.java"));
    // readLine读取一行，返回一行的字符串，判断是否是一行，根据换行符。
    // 读取的内容中不包含换行符
    // 如果没有剩余内容，返回 null

    String line = reader.readLine();
    while (line != null) {
      System.out.println(line);
      writer.write(line);
      writer.newLine();
      line = reader.readLine();
    }
    // 如果流被close，则自动回flush，如果没有flush且没有关闭流程序退出后，文件可能会没有被写入
    writer.flush();
    writer.close();
  }
}
