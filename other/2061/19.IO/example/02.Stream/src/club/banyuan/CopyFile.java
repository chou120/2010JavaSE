package club.banyuan;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class CopyFile {

  public static void main(String[] args) throws IOException {
    String from = "/Users/liyi/works/repos/banyuan/javase-2061/19.IO/doc/WIN.mp3";
    String to = "/Users/liyi/works/repos/banyuan/javase-2061/19.IO/example/copy.mp3";

    InputStream inputStream = new FileInputStream(from);
    OutputStream outputStream = new FileOutputStream(to);

    byte[] buf = new byte[1024];
    int count = inputStream.read(buf);

    while (count > 0) {
      outputStream.write(buf, 0, count);
      count = inputStream.read(buf);
    }


  }
}
