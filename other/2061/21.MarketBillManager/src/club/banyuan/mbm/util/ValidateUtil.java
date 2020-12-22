package club.banyuan.mbm.util;

import club.banyuan.mbm.BadRequestException;
import java.lang.reflect.Field;

public class ValidateUtil {

  public static void validate(Object object) {
    Field[] fields = object.getClass().getDeclaredFields();

    StringBuilder builder = new StringBuilder();
    for (Field field : fields) {
      RegexValidate annotation = field.getAnnotation(RegexValidate.class);
      if (annotation != null) {
        String value = null;
        try {
          // 尝试获取对象的私有变量的时候，需要先调用此方法
          field.setAccessible(true);
          value = (String) field.get(object);
        } catch (IllegalAccessException e) {
          builder.append(e.getMessage());
          builder.append(System.lineSeparator());
          // throw new BadRequestException(e);
        }

        if (!value.matches(annotation.regex())) {
          builder.append(annotation.msg());
          builder.append(System.lineSeparator());
        }
      }
    }

    if (builder.length() > 0) {
      throw new BadRequestException(builder.toString());
    }
  }
}
