package club.banyuan;

import java.lang.reflect.Field;

public class ValidateUtil {

  public static void validate(Object object) {
    Field[] fields = object.getClass().getDeclaredFields();

    for (Field field : fields) {
      MyAnnotation annotation = field.getAnnotation(MyAnnotation.class);
      if (annotation != null) {
        String value = null;
        try {
          // 尝试获取对象的私有变量的时候，需要先调用此方法
          field.setAccessible(true);
          value = (String) field.get(object);
        } catch (IllegalAccessException e) {
          throw new RuntimeException(e);
        }

        if (!value.matches(annotation.regex())) {
          throw new RuntimeException(annotation.msg());
        }
      }
    }
  }
}
