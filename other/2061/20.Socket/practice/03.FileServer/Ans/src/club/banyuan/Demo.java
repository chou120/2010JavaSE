package club.banyuan;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class Demo {

  public static void main(String[] args) throws IOException {
    File file = new File(
        "/Users/liyi/works/repos/banyuan/javase-2061/20.Socket/practice/03.FileServer/test");
    FileInputStream inputStream = new FileInputStream(file);
    // buffered 读取，将会读取inputstream中较多的数据，不止当前返回的数据，如果之后使用inputStream再读取数据，可能会导致，buffered一部分数据没有被读取
    BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

    System.out.println(inputStream.available());
    String s = reader.readLine();
    System.out.println(s);
    System.out.println(inputStream.available());

  }
}
