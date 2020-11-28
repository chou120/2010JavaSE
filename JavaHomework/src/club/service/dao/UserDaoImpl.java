package club.service.dao;

import club.service.entity.User;
import club.service.util.DataSource;

/**
 * @author sanye
 * @version 1.0
 * @date 2020/11/26 6:35 下午
 */
public class UserDaoImpl implements UserDao {

  @Override
  public boolean login(String username, String password) {
    for (int i = 0; i <DataSource.USER_ARRAY_LIST.size(); i++) {
       User o = (User)DataSource.USER_ARRAY_LIST.get(i);  //User
      if(o.getName().equals(username) && o.getPassword().equals(password) ){
            return  true;
        }
    }
    return false;
  }

  @Override
  public void register(User user) {
    //TODO
  }
}
