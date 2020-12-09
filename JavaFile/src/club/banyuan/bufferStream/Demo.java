package club.banyuan.bufferStream;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author sanye
 * @version 1.0
 * @date 2020/12/9 1:59 下午
 */
public class Demo {

  /**
   * 缓冲流作用
   *          由原来的一个一个字节读取，变成放到缓冲流（可配置字节数）进行批量操作，这样和底层的硬盘操作频率变少，效率提高。”
   *        从应用的角度，任何减少磁盘活动的策略都有帮助，例如使用带缓存的输入、输出流以减少读、写操作次数用以减少磁盘交互。“
   *
   *
   * @param args
   */

  public static void main(String[] args) throws IOException {
    File file =new File("JavaFile/src/student.txt");
    FileInputStream fileInputStream = new FileInputStream(file);
    BufferedInputStream      bufferedInputStream =new BufferedInputStream(fileInputStream);  //在大数据量操作 时候一般使用就是缓冲流 能提效率 减少与硬盘互动的时间

    byte[] bytes=new  byte[(int)file.length()];
    bufferedInputStream.read(bytes);

    System.out.println(new String(bytes));

    bufferedInputStream.close();
    fileInputStream.close();

    BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(
        new FileOutputStream(file,true));

    bufferedOutputStream.write(bytes);

    bufferedOutputStream.close();
  }
}
