package club.banyuan;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;

// 流：抽象  0 10 1110
// 流对象： 操作文件或其他数据是否支持转换为流对象，操作的方式，通过流的接口提供

// InputStream  程序，从外部写入数据到程序中，为Input
// OutputStream 从程序内部写入数据到外部，为Output
public class InputStreamDemo {

  public static void main(String[] args) throws IOException {
    File file = new File("/Users/liyi/works/repos/banyuan/javase-2061/19.IO/doc/WIN.mp3");
    InputStream demoInputStream = new FileInputStream(file);

    // 方式1
    // int target = -1;
    // int count = 0;
    // while ((target = demoInputStream.read()) != -1) {
    //   // System.out.println("读取数据:" + target);
    //   count++;
    // }
    // System.out.println("读取完毕");
    // System.out.println(count);
    // System.out.println(file.length());

    byte[] buffer = new byte[1024];
    int count = 0;
    int total = 0;
    while ((count = demoInputStream.read(buffer)) > 0) {
      System.out.println(Arrays.toString(buffer));
      System.out.println(count);
      total += count;
    }
    System.out.println("读取完毕");
    System.out.println(total);
    System.out.println(file.length());

    InputStream inputStream = new FileInputStream(file);

    // 返回流中剩余的数据长度
    int available = inputStream.available();
    // 读取流中的一个byte，如果读取到的是-1，则表示读取结束，流里面没有多余的数据
    inputStream.read();
    byte[] buf = new byte[1024];
    // 流里面的数据大于数组的长度，就会把数组填满，从0的位置开始装填，返回装填数组的长度值
    // 流里面的数据不足数组的长度，从0的位置开始装，直到流中数据填完为止，并且把一共装填了的数组长度返回
    int read = inputStream.read(buf);
    // 数组中下标 [0, read - 1] 之间的数据都是有效的数据

    // 第二个参数，传递一个数字，从数组的指定下标位置，开始装填数据
    // 第三个参数，传递一个数字，表示一共装填多少个byte到数组中
    // 如果流中的数据不足len给定的长度，返回值，表示真正装填的长度
    // int count = inputStream.read(buf, 0, 12);

    inputStream.readAllBytes();

    // 跳过流中指定的字节数，之后将从跳过之后的字节开始读取，返回实际跳过的字节数
    inputStream.skip(12);

    // 返回是否该流的实现类是否支持反复读取
    // inputStream.markSupported();

    // 通过mark在指定的位置标记，给入的参数，表示标记失效的读取数据的长度，超出标记长度，则可能导致reset失效
    // inputStream.mark(1000);
    // 重置到标记位置，开始继续读取
    // inputStream.reset();

  }

}
