package club.service.dao;

/**
 * @author sanye
 * @version 1.0
 * @date 2020/11/26 6:34 下午
 */
public interface UserDao {
  boolean login(String username,String password);
}
