package club.banyuan.test;

import club.banyuan.service.UserService;
import club.banyuan.util.ValidateUpdateData;
import java.lang.reflect.Proxy;

/**
 * @author sanye
 * @version 1.0
 * @date 2020/12/15 3:32 下午
 */
public class TestReflect {

  public static void main(String[] args) {
    UserService userService = new UserService();
    ValidateUpdateData validateUpdateData = new ValidateUpdateData(userService);



  }
}
