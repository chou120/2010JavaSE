package club.banyuan.userDemo;

/**
 * @author sanye
 * @version 1.0
 * @date 2020/11/18 11:12 上午
 */
public class UserService {

  private   User[] users=new User[5];
  {
    for (int i = 0; i <users.length; i++) {
      User user = new User();
      user.setUsername("张三"+i);
      user.setPassword("12345"+i);
      users[i]=user;
    }
  }

  //用户登录
  public   boolean login(User  user){
    //user 对象在数据库是否存在
    for (int i = 0; i <users.length; i++) {
      if(user.getUsername().equals(users[i].getUsername())){
        return true;
      }
    }
    return false;
  }

  //用户注册





}
