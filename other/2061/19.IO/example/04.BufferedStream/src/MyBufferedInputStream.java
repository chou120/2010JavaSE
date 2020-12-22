import java.io.IOException;
import java.io.InputStream;

// 装饰者设计模式
public class MyBufferedInputStream extends InputStream {

  private InputStream inputStream;

  // buffer未被读取的数据的数量
  private int count;
  private int pos;
  private byte[] buffer = new byte[1024];

  public MyBufferedInputStream(InputStream inputStream) throws IOException {
    this.inputStream = inputStream;
    // 初始化缓冲区
    count = inputStream.read(buffer);
  }

  @Override
  public int read() throws IOException {
    if (count <= 0) {
      return -1;
    }
    if (pos < count) {
      // 缓冲区里面有数据，从缓冲区里面取一个数据出去
      // 负数的byte 转换为int之后，高位补符号位 1，导致int为负数，因此需要与0xFF消除高位的符号位
      int rlt = buffer[pos] & 0xFF;

      pos++;
      return rlt;
    } else {
      // 缓冲区已经没有数据了
      count = inputStream.read(buffer);
      pos = 0;
      return read();
    }
  }
}
