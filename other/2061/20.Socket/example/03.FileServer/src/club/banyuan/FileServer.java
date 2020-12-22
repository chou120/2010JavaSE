package club.banyuan;

import com.alibaba.fastjson.JSONObject;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class FileServer {

  public static void main(String[] args) throws IOException {
    ServerSocket serverSocket = new ServerSocket(5000);
    Socket accept = serverSocket.accept();
    // 客户端接入
    InputStream inputStream = accept.getInputStream();
    // 先读4byte，读取到的是json对象字符串的长度
    byte[] lengthBytes = getBytes(inputStream, 4);

    // 将4byte转换为长度值
    int jsonLen = ByteToInt.toInt(lengthBytes);
    // 读取长度值这么多的byte，这些byte正好是json字符串的长度
    byte[] jsonBytes = getBytes(inputStream, jsonLen);
    // 将这个json字符串转换为FileInfo对象，对象中保存了后续文件的长度和文件名字
    FileInfo fileInfo = JSONObject.parseObject(jsonBytes, FileInfo.class);
    System.out.println(fileInfo);

    // 将读取文件长度这么多的byte
    byte[] buf = new byte[1024];
    long fileLeft = fileInfo.getLength();
    // 将读取到的文件内容写入到这个文件中，完成文件的保存
    File file = new File(
        "/Users/liyi/works/repos/banyuan/javase-2061/20.Socket/example/03.FileServer",
        fileInfo.getName());
    // 写入文件，需要开启文件的输出流
    BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(
        new FileOutputStream(file));
    // 读取的时候，需要保证总的读取数量不要读多了，超出了FileInfo中length的长度
    int read = inputStream.read(buf, 0, (int) Math.min(fileLeft, buf.length));
    while (fileLeft > 0) {
      bufferedOutputStream.write(buf, 0, read);
      fileLeft -= read;
      read = inputStream.read(buf, 0, (int) Math.min(fileLeft, buf.length));
    }

    bufferedOutputStream.close();
    accept.close();

  }

  private static byte[] getBytes(InputStream inputStream, int total) throws IOException {
    byte[] lengthBytes = new byte[total];
    int len = inputStream.read(lengthBytes);
    if (len != lengthBytes.length) {
      throw new IllegalArgumentException("读取长度错误");
    }
    return lengthBytes;
  }
}
