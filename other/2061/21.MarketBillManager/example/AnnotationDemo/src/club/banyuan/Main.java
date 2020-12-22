package club.banyuan;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

public class Main {

  public static void main(String[] args) {
    //
    // Field[] fields = User.class.getDeclaredFields();
    // for (Field field : fields) {
    //   Annotation annotation = field.getAnnotation(MyAnnotation.class);
    //   System.out.println(annotation);
    // }


    User user = new User();
    user.setName("张三");

    ValidateUtil.validate(user);
  }
}
