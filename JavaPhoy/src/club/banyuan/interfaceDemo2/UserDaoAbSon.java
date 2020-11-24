package club.banyuan.interfaceDemo2;

import club.banyuan.interfaceDemo.User;

/**
 * @author sanye
 * @version 1.0
 * @date 2020/11/24 11:27 上午
 */
public class UserDaoAbSon  extends  UserDaoAb{

  String   ADDRESS="美元";

  @Override
  public void add() {

    System.out.println(UserDao.ADDRESS);
  }

  @Override
  public void login(String name) {

  }
}
class Test{

  public static void main(String[] args) {
    new  UserDaoAbSon().add();
  }
}