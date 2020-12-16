package club.banyuan.util;

import club.banyuan.service.UserService;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author sanye
 * @version 1.0
 * @date 2020/12/15 3:24 下午
 */
public class ValidateUpdateData  implements InvocationHandler {

   //需要代理的对象 这里我们是对在做添加的时候先做验证

  private UserService  userService;

  public ValidateUpdateData(UserService userService) {
    this.userService = userService;
  }

  @Override
  public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {



    Object invoke = method.invoke(userService, args); //这是执行的目标方法
    return invoke;
  }
}
