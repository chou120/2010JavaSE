package club.banyuan;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class WriteUserDemo {

  // 对象序列化，将对象转换为可以保存或者传输的数据格式
  // 张三123456
  public static void main(String[] args) throws IOException {
    User user = new User();
    user.setName("张三");
    user.setPwd("123456");

    // 对象序列化   file => outputStream  / Writer
    // => objectOutputStream
    ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(
        "/Users/liyi/works/repos/banyuan/javase-2061/19.IO/example/05.ObjectSerial/User"));
    objectOutputStream.writeObject(user);
    objectOutputStream.flush();
    objectOutputStream.close();
  }
}
