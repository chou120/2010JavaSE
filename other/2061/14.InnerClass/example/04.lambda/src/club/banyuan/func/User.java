package club.banyuan.func;

import java.util.Arrays;
import java.util.Comparator;

public class User {

  private String name;
  private int age;

  public User(String name, int age) {
    this.name = name;
    this.age = age;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  @Override
  public String toString() {
    return "User{" +
        "name='" + name + '\'' +
        ", age=" + age +
        '}';
  }

  public static void main(String[] args) {
    User[] users = new User[]{
        new User("A", 20),
        new User("C", 18),
        new User("D", 15),
        new User("G", 33),
        new User("E", 22),
    };

    // int 方法(对象1，对象2)
    Arrays.sort(users, (Comparator.comparing(User::getName)));
    Arrays.sort(users, (Comparator.comparing(User::getAge)));

    System.out.println(Arrays.toString(users));
  }
}
