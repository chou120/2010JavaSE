package club.banyuan;

public class Main {

  public static void main(String[] args) {
    // User user = new User("张三", 20, "男");
    // System.out.println(user);
    // 使用字符串或数字表示有限个类型的时候，没有办法进行编译时检查，类型不安全
    // user.setGender("李四");
    // System.out.println(user);

    // 程序运行的时候 Gender类，只有两个对象，一个对象表示男，一个对象表示女
    UserRefine user = new UserRefine("张三", 20, Gender.MALE);
    System.out.println(user);

    user.setGender(Gender.FEMALE);
    System.out.println(user);

    UserRefine u2 = new UserRefine("李四", 30, Gender.FEMALE);
    // 因为有限个对象，因此比较地址值来比较是否具有相同的类型。
    System.out.println(u2.getGender() == user.getGender());

    // 类型对象到字符串的转换，以及字符串到对象的转换
    UserRefine u3 = new UserRefine("王五", 40, Gender.valueOf("男"));

  }
}
