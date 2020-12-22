package club.banyuan;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class ReadUserDemo {

  // 对象反序列化，将从文件或其他来源读取到的数据，转换为对象
  public static void main(String[] args) throws IOException, ClassNotFoundException {
    ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(
        "/Users/liyi/works/repos/banyuan/javase-2061/19.IO/example/05.ObjectSerial/User"));

    Object o = inputStream.readObject();

    User user = (User) o;
    System.out.println(user);
  }
}
