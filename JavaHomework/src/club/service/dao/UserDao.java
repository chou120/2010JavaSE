package club.service.dao;

import club.service.entity.User;

/**
 * @author sanye
 * @version 1.0
 * @date 2020/11/26 6:34 下午
 */
public interface UserDao {

  boolean login(String username,String password);

  /**
   * 用户名不得低于2个字符不得高于10字符,用户名不得以数字开头
   *
   * 密码长度最低6最高8个,用户名和密码必须是数字和字母混合,如果不混合给提出提:密码必须是数字和字母的组合
   *
   * @param user
   */
  void  register(User user);

}
