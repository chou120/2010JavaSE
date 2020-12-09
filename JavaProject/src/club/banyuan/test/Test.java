package club.banyuan.test;

import com.alibaba.fastjson.JSONObject;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author sanye
 * @version 1.0
 * @date 2020/12/9 11:48 上午
 */
public class Test {

  public static void main(String[] args) {
    //往json文件中添加对象
    String str="{\"id\":1234,\"username\":\"李四\",\"address\":\"栖霞区\",\"age\":34}";
    User user = JSONObject.parseObject(str, User.class);
    System.out.println(user.toString());

    List<User> list=new ArrayList<>();
    list.add(new User(12,"李大鹏","玄武",21));
    list.add(new User(13,"李大鹏2","玄武2",21));
    list.add(new User(14,"李大鹏3","玄武3",21));
    list.add(new User(15,"李大鹏4","玄武4",21));

    //将集合转换成json字符串
    String string = JSONObject.toJSONString(list);
    File  file=new File("user.json");
    if(!file.exists()){
      try {
        file.createNewFile();
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
    try ( FileWriter  fileWriter=new FileWriter(file)){
        fileWriter.write(string);

    } catch (IOException e) {
      e.printStackTrace();
    }

    //将json数据内容读取出来
    try (FileReader reader = new FileReader(file)) {

      char[] buf = new char[(int)file.length()];
      reader.read(buf);
      String  strBuf=new String(buf);

      List<User> list1 = JSONObject.parseArray(strBuf, User.class);
      System.out.println(list1);

    } catch (IOException e) {
      e.printStackTrace();
    }


  }
}
class User{
  private Integer id;
  private String  username;
  private String  address;
  private Integer age;

  public User() {
  }

  public User(Integer id, String username, String address, Integer age) {
    this.id = id;
    this.username = username;
    this.address = address;
    this.age = age;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public Integer getAge() {
    return age;
  }

  public void setAge(Integer age) {
    this.age = age;
  }

  @Override
  public String toString() {
    return "User{" +
        "id=" + id +
        ", username='" + username + '\'' +
        ", address='" + address + '\'' +
        ", age=" + age +
        '}';
  }
}