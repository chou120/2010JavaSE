package club.banyuan;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

  public static void main(String[] args) {

    List<User> userList = loadOnByOneRefine();

    while (true) {
      printUserInfo(userList);

      System.out.println("1.添加用户");
      System.out.println("0.退出");

      Scanner scanner = new Scanner(System.in);
      String input = scanner.nextLine();

      switch (input) {
        case "1":
          addUser(userList);
          saveOneByOneRefine(userList);
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
    try (FileInputStream fileInputStream = new FileInputStream(
        "/Users/liyi/works/repos/banyuan/javase-2061/19.IO/example/05.ObjectSerial/UserList");
        ObjectInputStream inputStream = new ObjectInputStream(fileInputStream);
    ) {
      Object o = inputStream.readObject();
      return (List<User>) o;

    } catch (IOException | ClassNotFoundException e) {
      e.printStackTrace();
    }
    return new ArrayList<>();
  }

  private static List<User> loadOnByOne() {
    List<User> rlt = new ArrayList<>();
    try (FileInputStream fileInputStream = new FileInputStream(
        "/Users/liyi/works/repos/banyuan/javase-2061/19.IO/example/05.ObjectSerial/UserList");
        ObjectInputStream inputStream = new ObjectInputStream(fileInputStream);
    ) {

      // System.out.println(inputStream.available());
      // while (inputStream.available() > 0){
      //   Object o = inputStream.readObject();
      //   rlt.add((User) o);
      // }

      Object o = inputStream.readObject();
      while (o != null) {
        rlt.add((User) o);
        o = inputStream.readObject();
      }
    } catch (IOException | ClassNotFoundException e) {
      e.printStackTrace();
    } catch (Exception e) {
      e.printStackTrace();
    }
    return rlt;
  }

  private static List<User> loadOnByOneRefine() {
    List<User> rlt = new ArrayList<>();
    try (FileInputStream fileInputStream = new FileInputStream(
        "/Users/liyi/works/repos/banyuan/javase-2061/19.IO/example/05.ObjectSerial/UserList");
        ObjectInputStream inputStream = new ObjectInputStream(fileInputStream);
    ) {

      // System.out.println(inputStream.available());
      // while (inputStream.available() > 0){
      //   Object o = inputStream.readObject();
      //   rlt.add((User) o);
      // }

      // 第一次读取到的应该是一个数字，表示后面需要再读取多少次
      int count = inputStream.readInt();
      // 读取count这么多次
      while (count > 0) {
        Object o = inputStream.readObject();
        rlt.add((User) o);
        count--;
      }
    } catch (IOException | ClassNotFoundException e) {
      e.printStackTrace();
    } catch (Exception e) {
      e.printStackTrace();
    }
    return rlt;
  }

  private static void save(List<User> userList) {
    try (FileOutputStream fileOutputStream = new FileOutputStream(
        "/Users/liyi/works/repos/banyuan/javase-2061/19.IO/example/05.ObjectSerial/UserList");
        ObjectOutputStream outputStream = new ObjectOutputStream(fileOutputStream);
    ) {
      outputStream.writeObject(userList);
      outputStream.flush();
    } catch (IOException e) {
      e.printStackTrace();
    }

  }

  private static void saveOneByOne(List<User> userList) {
    try (FileOutputStream fileOutputStream = new FileOutputStream(
        "/Users/liyi/works/repos/banyuan/javase-2061/19.IO/example/05.ObjectSerial/UserList");
        ObjectOutputStream outputStream = new ObjectOutputStream(fileOutputStream);
    ) {
      for (User user : userList) {
        outputStream.writeObject(user);
      }
      // 如果逐个写入，文件读取的时候，最后无法判断是否读到头了，因此需要写一个null标识文件结束
      outputStream.writeObject(null);
      outputStream.flush();
    } catch (IOException e) {
      e.printStackTrace();
    }

  }

  private static void saveOneByOneRefine(List<User> userList) {
    try (FileOutputStream fileOutputStream = new FileOutputStream(
        "/Users/liyi/works/repos/banyuan/javase-2061/19.IO/example/05.ObjectSerial/UserList");
        ObjectOutputStream outputStream = new ObjectOutputStream(fileOutputStream);
    ) {
      // 先写一个数字，表示对象的数量
      outputStream.writeInt(userList.size());
      for (User user : userList) {
        outputStream.writeObject(user);
      }
      outputStream.flush();
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
