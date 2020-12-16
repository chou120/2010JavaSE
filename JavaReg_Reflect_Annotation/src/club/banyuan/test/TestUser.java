package club.banyuan.test;

import java.lang.reflect.Field;

/**
 * @author sanye
 * @version 1.0
 * @date 2020/12/16 4:29 下午
 */
public class TestUser {

  public static void main(String[] args) throws IllegalAccessException {
    User user = new User();
    user.setUsername("&%sada"); //
    user.setPassword("123365");

    boolean  flag=validate(user); //作为消息验证

    if(flag){
      System.out.println("执行添加操作");
    }
  }

  private static boolean validate(Object object) throws IllegalAccessException {
    Class<?> aClass = object.getClass();
    Field[] declaredFields = aClass.getDeclaredFields();
    for (Field declaredField : declaredFields) {
      declaredField.setAccessible(true);
      TestUserAnnotation annotation = declaredField.getAnnotation(TestUserAnnotation.class);
        if(declaredField.getName().equals("username")){
          //获取字段的值
          String o = (String)declaredField.get(object);
          if(!o.matches(annotation.reg())){
            System.out.println(annotation.msg());
            return false;
          }
        }

      if(declaredField.getName().equals("password")){
        //获取字段的值
        String o = (String)declaredField.get(object);
        if(!o.matches(annotation.reg())){
          System.out.println(annotation.msg());
          return false;
        }
      }

    }
    return true;
  }
}
