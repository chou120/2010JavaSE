package club.banyuan;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Arrays;

public class OutputStreamDemo {

  public static void main(String[] args) throws IOException {
    // OutputStream outputStream = new FileOutputStream(
    //     "/Users/liyi/works/repos/banyuan/javase-2061/19.IO/example/text");

    // 给第二个boolean类型的参数，为true，表示追加，如果文件存在，则向输出流里面写入的内容会被追加到文件尾部，如果文件不存在，则创建文件，写入数据
    OutputStream outputStream = new FileOutputStream(
        "/Users/liyi/works/repos/banyuan/javase-2061/19.IO/example/text", false);

    // 写入int 数值的低8bit
    outputStream.write(0x12);
    // byte[] bytes = "你好".getBytes();
    // System.out.println(Arrays.toString(bytes));
    // 将字节数组的所有内容，写入到输出流中
    // outputStream.write(bytes);

    // 将字节数组的内容，从第二个参数下标起始，写入第三个参数指定的个数
    // outputStream.write(bytes, 3, 3);

  }
}
