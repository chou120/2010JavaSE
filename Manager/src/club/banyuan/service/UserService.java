package club.banyuan.service;

import club.banyuan.entity.User;

/**
 * @author sanye
 * @version 1.0
 * @date 2020/12/11 10:27 上午
 */
public class UserService {

  public User login(User user) {
      if(user.getName().equals("zhangsan") && user
      .getPwd().equals("123456")){

        return   user;
      }
      return  null;
  }
}
