package club.banyuan;

import com.alibaba.fastjson.JSONObject;
import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import netscape.javascript.JSObject;

public class WriteUserDemo {

  // 对象序列化，将对象转换为可以保存或者传输的数据格式
  // 张三123456
  public static void main(String[] args) throws IOException {
    User user = new User();
    user.setName("张三");
    user.setPwd("123456");

    // 对象序列化，将User对象转换为  json格式的字符串

    BufferedWriter outputStream = new BufferedWriter(new FileWriter(
        "/Users/liyi/works/repos/banyuan/javase-2061/19.IO/example/06.JsonSerial/User.json"));

    String target = JSONObject.toJSONString(user);
    System.out.println(target);
    outputStream.write(target);
    outputStream.flush();
    outputStream.close();

    // JSObject objectOutputStream = new ObjectOutputStream();
    // objectOutputStream.writeObject(user);
    // objectOutputStream.flush();
    // objectOutputStream.close();
  }
}
