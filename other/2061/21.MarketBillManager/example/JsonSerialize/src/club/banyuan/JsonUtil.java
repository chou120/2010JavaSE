package club.banyuan;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.lang.reflect.Type;

public class JsonUtil {

  // {"id":1,"name":"小米","desc":"are your ok"}
  public static String toJsonString(Object obj) {

    StringBuilder builder = new StringBuilder();
    builder.append("{");

    Method[] declaredMethods = obj.getClass().getDeclaredMethods();
    for (Method declaredMethod : declaredMethods) {
      String name = declaredMethod.getName();
      if (name.startsWith("get")) {
        try {
          Object value = declaredMethod.invoke(obj);
          // 截取get后面的内容，将首字母小写，作为属性名称
          String propName = name.substring(4);
          propName = (name.charAt(3) + "").toLowerCase() + propName;
          builder.append("\"").append(propName).append("\":");
          if (value instanceof Integer) {
            builder.append(value).append(",");
          } else {
            builder.append("\"").append(value.toString()).append("\",");
          }
        } catch (IllegalAccessException | InvocationTargetException e) {
          e.printStackTrace();
        }
      }
    }

    if (builder.length() > 1) {
      // 移除最后一个逗号
      builder.deleteCharAt(builder.lastIndexOf(","));
    }

    builder.append("}");

    return builder.toString();
  }

  public static <T> T parseObject(String str, Class<T> aClass) {
    T obj = null;
    try {
      // 创建对象
      obj = aClass.getConstructor().newInstance();
    } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
      e.printStackTrace();
      System.out.println("创建对象失败");
      return null;
    }
    String source = str.substring(1, str.length() - 1);
    String[] split = source.split(",");
    for (String entry : split) {
      String[] kv = entry.replaceAll("\"", "").split(":");
      String methodName = "set" + (kv[0].charAt(0) + "").toUpperCase() + kv[0].substring(1);
      try {
        System.out.println(methodName);
        for (Method declaredMethod : aClass.getDeclaredMethods()) {
          Type genericReturnType = declaredMethod.getGenericReturnType();
          declaredMethod.getReturnType();
          if (methodName.equals(declaredMethod.getName())) {
            Parameter parameter = declaredMethod.getParameters()[0];
            System.out.println("kv=" + kv[1]);
            if (parameter.getType() == int.class) {
              declaredMethod.invoke(obj, Integer.parseInt(kv[1]));
            } else if (parameter.getType() == String.class) {
              declaredMethod.invoke(obj, kv[1]);
            }
          }
        }

      } catch (IllegalAccessException | InvocationTargetException e) {
        e.printStackTrace();
      }
    }

    return obj;
  }
}
