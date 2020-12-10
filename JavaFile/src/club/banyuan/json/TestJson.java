package club.banyuan.json;

import com.alibaba.fastjson.JSONObject;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author sanye
 * @version 1.0
 * @date 2020/12/9 3:30 下午
 */
public class TestJson {

  public static void main(String[] args) {
    //json格式的字符串

    String str = "{\"name\":\"张三\",\"age\":23,\"address\":\"栖霞区\"}";
    //字符串转换成对象
    User user = JSONObject.parseObject(str, User.class);
    System.out.println(user.toString());

    File file = new File(
        "/Users/sanye/2010/2010JavaSE/JavaFile/src/club/banyuan/json/user.json");

     List<Food> foods = Arrays.asList(new Food("苹果",12.3,2.5,"红色"),
         new Food("橘子",13.4,2.6,"黄色"),
         new Food("芒果",1.4,5.6,"黄色"));

    List<User> list = new ArrayList<>();
    list.add(new User("张三丰", 120, "武当山",foods));
    list.add(new User("张三丰2", 121, "武当山2",null));
    list.add(new User("张三丰3", 122, "武当山3",null));
    list.add(new User("张三丰4", 123, "武当山4",foods));

    String string = JSONObject.toJSONString(list);

    //# key= value
    try (FileWriter fileWriter = new FileWriter(file)) {
      fileWriter.write(string);

    } catch (IOException e) {
      e.printStackTrace();
    }

//
    try (FileReader fileReader = new FileReader(file)) {
      char[] chars = new char[(int) file.length()];
      int key = 0;
      int read = fileReader.read();
      while (read != -1) {
        chars[key++] = (char) read;
        read = fileReader.read();
      }
      String s = new String(chars, 0, key);
//单个对象解析
//      User user1 = JSONObject.parseObject(s, User.class);
//      System.out.println(">>>>>>>"+user1.toString());

      //解析的是集合
      List<User> list1 = JSONObject.parseArray(s, User.class);
      System.out.println(list1.get(0).toString());


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

  private List<Food>  list;

  public List<Food> getList() {
    return list;
  }

  public void setList(List<Food> list) {
    this.list = list;
  }

  public User() {
  }

  public User(String name, Integer age, String address, List<Food> list) {
    this.name = name;
    this.age = age;
    this.address = address;
    this.list = list;
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
        ", list=" + list +
        '}';
  }
}

class  Food{
  private String name;
  private Double price;
  private Double weight;
  private String color;

  public Food() {
  }

  public Food(String name, Double price, Double weight, String color) {
    this.name = name;
    this.price = price;
    this.weight = weight;
    this.color = color;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Double getPrice() {
    return price;
  }

  public void setPrice(Double price) {
    this.price = price;
  }

  public Double getWeight() {
    return weight;
  }

  public void setWeight(Double weight) {
    this.weight = weight;
  }

  public String getColor() {
    return color;
  }

  public void setColor(String color) {
    this.color = color;
  }

  @Override
  public String toString() {
    return "Food{" +
        "name='" + name + '\'' +
        ", price=" + price +
        ", weight=" + weight +
        ", color='" + color + '\'' +
        '}';
  }
}