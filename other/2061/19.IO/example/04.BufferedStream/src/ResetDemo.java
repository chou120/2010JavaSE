import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ResetDemo {

  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new FileReader(
        "/Users/liyi/works/repos/banyuan/javase-2061/19.IO/example/03.CharStream/src/club/banyuan/ReaderDemo.java"));
    // readLine读取一行，返回一行的字符串，判断是否是一行，根据换行符。
    // 读取的内容中不包含换行符
    // 如果没有剩余内容，返回 null

    reader.mark(1);
    String line = reader.readLine();
    System.out.println(line);
    line = reader.readLine();
    System.out.println(line);
    line = reader.readLine();
    System.out.println(line);
    reader.reset();
    System.out.println("========");
    line = reader.readLine();
    System.out.println(line);
    line = reader.readLine();
    System.out.println(line);

    // while (line != null) {
    //   System.out.println(line);
    //   // System.out.println(reader.readLine());
    //   line = reader.readLine();
    // }

    reader.reset();

    System.out.println("================");
    line = reader.readLine();
    System.out.println(line);
    // while (line != null) {
    //   System.out.println(line);
    //   // System.out.println(reader.readLine());
    //   line = reader.readLine();
    // }

  }
}
