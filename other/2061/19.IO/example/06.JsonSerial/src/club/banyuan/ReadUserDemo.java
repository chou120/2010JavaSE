package club.banyuan;

import com.alibaba.fastjson.JSONObject;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;

public class ReadUserDemo {

  // 对象反序列化，将从文件或其他来源读取到的数据，转换为对象
  public static void main(String[] args) throws IOException, ClassNotFoundException {
    BufferedReader reader = new BufferedReader(new FileReader(
        "/Users/liyi/works/repos/banyuan/javase-2061/19.IO/example/06.JsonSerial/User.json"));

    StringBuilder builder = new StringBuilder();
    String line = reader.readLine();
    while (line != null) {
      builder.append(line);
      line = reader.readLine();
    }

    String target = builder.toString();

    // 通过字符串转换对象的时候，需要告知反转对象的类
    User user = JSONObject.parseObject(target, User.class);
    // User user = (User) parse;
    System.out.println(user);

  }
}
