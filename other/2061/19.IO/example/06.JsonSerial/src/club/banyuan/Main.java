package club.banyuan;

import com.alibaba.fastjson.JSONObject;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

  public static final String STORE_FILE_PATH = "/Users/liyi/works/repos/banyuan/javase-2061/19.IO/example/05.ObjectSerial/UserList.json";

  public static void main(String[] args) {

    List<User> userList = load();

    while (true) {
      printUserInfo(userList);

      System.out.println("1.添加用户");
      System.out.println("0.退出");

      Scanner scanner = new Scanner(System.in);
      String input = scanner.nextLine();

      switch (input) {
        case "1":
          addUser(userList);
          save(userList);
          break;
        case "0":
          return;
        default:
          System.out.println("不合法输入");
          break;
      }
    }
  }

  private static List<User> load() {
    try (FileReader fileReader = new FileReader(
        "/Users/liyi/works/repos/banyuan/javase-2061/19.IO/example/05.ObjectSerial/UserList.json");
        BufferedReader reader = new BufferedReader(fileReader);
    ) {
      StringBuilder builder = new StringBuilder();
      String line = reader.readLine();
      while (line != null) {
        builder.append(line);
        line = reader.readLine();
      }

      return JSONObject.parseArray(builder.toString(), User.class);
    } catch (IOException e) {
      e.printStackTrace();
    }
    return new ArrayList<>();
  }


  private static void save(List<User> userList) {
    try (FileWriter fileWriter = new FileWriter(
        STORE_FILE_PATH);
        BufferedWriter writer = new BufferedWriter(fileWriter);
    ) {
      writer.write(JSONObject.toJSONString(userList));
      writer.flush();
    } catch (IOException e) {
      e.printStackTrace();
    }

  }

  private static void addUser(List<User> userList) {
    Scanner scanner = new Scanner(System.in);
    User user = new User();
    System.out.println("用户名：");
    String name = scanner.nextLine();
    user.setName(name);
    System.out.println("密码：");
    String pwd = scanner.nextLine();
    user.setPwd(pwd);
    userList.add(user);
    System.out.println("操作成功");
  }

  private static void printUserInfo(List<User> userList) {
    System.out.println("==================");
    for (User user : userList) {
      System.out.println(user);
    }
    System.out.println("==================");
  }
}
