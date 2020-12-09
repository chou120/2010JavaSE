package club.banyuan.json;

import com.alibaba.fastjson.JSONObject;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;

/**
 * @author sanye
 * @version 1.0
 * @date 2020/12/9 3:30 下午
 */
public class TestJson {

  public static void main(String[] args) {
      //json格式的字符串

    String  str="{\"name\":\"张三\",\"age\":23,\"address\":\"栖霞区\"}";
    //字符串转换成对象
    User user = JSONObject.parseObject(str, User.class);
    System.out.println(user.toString());


    File file = new File(
        "/Users/sanye/2010/2010JavaSE/JavaFile/src/club/banyuan/json/user.json");

   /* String string = JSONObject.toJSONString(user);
    //# key= value
    try(FileWriter fileWriter = new FileWriter(file)) {
       fileWriter.write(string);
    } catch (IOException e) {
      e.printStackTrace();
    }
*/
    try (FileReader fileReader = new FileReader(file)) {
      char[] chars=new  char[(int)file.length()];
      int  key=0;
       int read = fileReader.read();
      while(read!=-1){
        chars[key++]=(char) read;
        read = fileReader.read();
      }
      String s = new String(chars, 0, key);

      User user1 = JSONObject.parseObject(s, User.class);
      System.out.println(">>>>>>>"+user1.toString());

    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}

class User implements Serializable {
  //序列化的版本号 为了让数据以当前的版本号进行序列化
  private static final long serialVersionUID = 42L;
  private String name;
  private Integer age;
  private String address;

  public User() {
  }

  public User(String name, Integer age, String address) {
    this.name = name;
    this.age = age;
    this.address = address;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Integer getAge() {
    return age;
  }

  public void setAge(Integer age) {
    this.age = age;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  @Override
  public String toString() {
    return "User{" +
        "name='" + name + '\'' +
        ", age=" + age +
        ", address='" + address + '\'' +
        '}';
  }
}

