package club.banyuan.objectStream;

import java.io.BufferedReader;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author sanye
 * @version 1.0
 * @date 2020/12/9 2:56 下午
 */
public class ObjStreamDemo {

  public static void main(String[] args) {
    File file = new File("JavaFile/src/User.txt");
    if (!file.exists()) {
      try {
        file.createNewFile();
      } catch (IOException e) {
        e.printStackTrace();
      }
    }

    List<User> list = new ArrayList<>();
    list.add(new User("沾上干1号", 23, "北大"));
    list.add(new User("沾上干2号", 22, "青大"));
    list.add(new User("沾上干3号", 21, "甘大"));
    list.add(new User("沾上干4号", 28, "鲁大"));
    list.add(new User("沾上干5号", 24, "哈大"));

//    try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file,true))) {
//      for (User user : list) {
//        bufferedWriter.write(user.getName()+","+user.getAddress()+","+user.getAge());
//        bufferedWriter.newLine();
//        bufferedWriter.flush();
//      }
//    } catch (IOException e) {
//      e.printStackTrace();
//    }

    /*list.clear();

    try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
      String s = bufferedReader.readLine(); //沾上干1号,北大,23
      while (s != null) {
        String[] split = s.split(",");
        User user = new User(split[0], Integer.valueOf(split[2]), split[1]);
        list.add(user);
        s=bufferedReader.readLine();
      }
      System.out.println(list);
    } catch (IOException e) {
      e.printStackTrace();
    }
      */

    //对象流    java.io.NotSerializableException: club.banyuan.objectStream.User
//    try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(
//        new FileOutputStream(file, true))) {
//      for (User user : list) {
//        objectOutputStream.writeObject(user);
//      }
//    } catch (IOException e) {
//      e.printStackTrace();
//    }

      try(ObjectInputStream  objectInputStream=new ObjectInputStream(new FileInputStream(file))){
         Object object = objectInputStream.readObject();
        while(object!=null){
          try {
            User user=(User)object;
            System.out.println(user.toString());
            object = objectInputStream.readObject();
          }catch (EOFException  e){ //EOF 表示文件读取结束 一个标志
            System.out.println("文件读取结束了...");
            break;
          }
        }
      }catch (IOException  e){
        e.printStackTrace();
      } catch (ClassNotFoundException e) {
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

