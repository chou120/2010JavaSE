package club.banyuan.service;

/**
 * @author sanye
 * @version 1.0
 * @date 2020/11/30 1:53 下午
 */
public class TestUser {

  public static void main(String[] args) {
    User user = new User();
//     user.setGender("你好");
//     user.setSex('x');

//    System.out.println(user.toString());
    user.setGender("你好");
    user.setSex(Gender.FEMALE);

  }
}
