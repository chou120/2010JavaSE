package club.banyuan.service;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author sanye
 * @version 1.0
 * @date 2020/12/16 4:25 下午
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface TestUserAnnotation {

  String reg() ;

  String  msg() default "正则表达式匹配错误";

}
