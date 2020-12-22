package club.banyuan;

import com.alibaba.fastjson.JSONObject;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class FileClient {

  public static void main(String[] args) throws IOException {
    Socket socket = new Socket("127.0.0.1", 5000);
    OutputStream outputStream = socket.getOutputStream();
    File file = new File("/Users/liyi/Desktop/c.pdf");
    FileInfo fileInfo = new FileInfo(file.getName(), file.length());
    String fileInfoStr = JSONObject.toJSONString(fileInfo);
    System.out.println(fileInfoStr.getBytes().length);
    // 先写4byte，这个长度是json对象的字符串的byte数组的长度
    outputStream.write(ByteToInt.toBytes(fileInfoStr.getBytes().length));
    // 再写json对象字符串的byte数组全部内容
    outputStream.write(fileInfoStr.getBytes());

    BufferedInputStream bufferedInputStream = new BufferedInputStream(
        new FileInputStream(file));
    // 读取文件的所有内容，写入到输出流中
    byte[] buf = new byte[1024];
    int count = bufferedInputStream.read(buf);
    while (count > 0) {
      outputStream.write(buf, 0, count);
      count = bufferedInputStream.read(buf);
    }

    bufferedInputStream.close();
    socket.close();

    // OutputStream outputStream = socket.getOutputStream();
    // // 4byte        c.pdf                4byte            文件内容
    // // 1001 0010    1101 0111 1001 1111  1000 1000        0011 1101
    // outputStream.write("c.pdf".getBytes());
    // BufferedInputStream bufferedInputStream = new BufferedInputStream(
    //     new FileInputStream("/Users/liyi/Desktop/c.pdf"));
    //
    //
    // // "{\"fileName\":\"c.pdf\",\"fileLength\":89600}"
    //
    // byte[] buf = new byte[1024];
    // int count = bufferedInputStream.read(buf);
    // while (count > 0) {
    //   outputStream.write(buf, 0, count);
    //   count = bufferedInputStream.read(buf);
    // }
    //
    // bufferedInputStream.close();
    // outputStream.close();

  }
}
