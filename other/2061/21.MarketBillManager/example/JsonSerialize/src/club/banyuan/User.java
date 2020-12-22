package club.banyuan;

import java.lang.reflect.InvocationTargetException;

public class User {

  int id;

  public User(int id) {
    this.id = id;
  }

  @Override
  public String toString() {
    return "User{" +
        "id=" + id +
        '}';
  }

  public static void main(String[] args)
      throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
    Class<?> aClass = Class.forName("club.banyuan.User");
    Object obj = aClass.getConstructor(int.class).newInstance(15);
    System.out.println(obj);
  }
}
