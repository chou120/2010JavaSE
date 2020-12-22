package club.banyuan.mbm.util;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// 配置注解在运行时生效，可以通过反射的方式进行获取
@Retention(RetentionPolicy.RUNTIME)
// 表示注解能够被放置的位置
@Target(ElementType.FIELD)
public @interface RegexValidate {

  // 用来做校验的正则表达式
  String regex();

  // 如果校验失败，返回的错误信息
  // 使用 default表示可以在注解声明的位置，不写该属性的值，使用默认值
  String msg() default "";

}
