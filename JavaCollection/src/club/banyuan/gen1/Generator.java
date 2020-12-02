package club.banyuan.gen1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Objects;

/**
 * @author sanye
 * @version 1.0
 * @date 2020/12/1 1:35 下午
 */
public interface Generator<T> {

  void insert(T t);

  T deleteUser(T t);

  void updateUser(T t);

  T getByUser(T t);

}

class GeneratorIml<T> implements Generator<T> {//T  就是类型(class文件)的占位符

  Collection<T> con = new ArrayList<>();

  @Override
  public void insert(T t) {
    con.add(t);
  }

  @Override
  public T deleteUser(T t) {
    T[] toArray = (T[]) con.toArray();
    T ta = null;
    for (int i = 0; i < toArray.length; i++) {
      if (toArray[i].equals(t)) {
        ta = toArray[i];
        con.remove(t);
      }
    }
    return ta;
  }

  @Override
  public void updateUser(T t) { //User  Product
    // 对传递过来数据里面的满足字符串属性的信息进行修改,在后面拼接一个"banyuan"
//    String banyuan = t.getName() + "banyuan";
//    t.setName(banyuan);
  }

  @Override
  public T getByUser(T t) {
    return null;
  }
}

class TestUser {

  public static void main(String[] args) {
    User user0 = new User("张三", 21);
    User user1 = new User("张三2", 21);


    GeneratorIml<User> generator = new GeneratorIml<>();
    generator.insert(user0);
    generator.insert(user1);


    System.out.println("------>>>>>>" + generator.con);

    User user2 = new User("张三", 21);

    User user = generator.deleteUser(user2);
    System.out.println(user);
    System.out.println("------>>>>>>" + generator.con);

//    GeneratorIml<Integer> generatorInteger = new GeneratorIml<>();
//    generatorInteger.insert(new Product());
//    generatorInteger.insert(31);
//    generatorInteger.insert(2534);
//    generatorInteger.insert(21);

//    System.out.println("integer....." + generatorInteger.con);
//
//    generatorInteger.deleteUser(21);
//
//    System.out.println("integer....." + generatorInteger.con);

  }
}


class User {

  private String name;
  private Integer age;

  public User() {
  }

  public User(String name, Integer age) {
    this.name = name;
    this.age = age;
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

  @Override
  public String toString() {
    return "User{" +
        "name='" + name + '\'' +
        ", age=" + age +
        '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    User user = (User) o;
    return Objects.equals(name, user.name) &&
        Objects.equals(age, user.age);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, age);
  }
}

class Product  extends  User{

}
