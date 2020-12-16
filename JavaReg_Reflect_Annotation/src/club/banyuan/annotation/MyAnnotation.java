package club.banyuan.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author sanye
 * @version 1.0
 * @date 2020/12/16 4:01 下午
 */

@Target({ElementType.FIELD,ElementType.METHOD}) //表示自定义注解只能放在字段上（属性）
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnnotation {
    //表示注解信息
    String   value()  default "又菜又爱玩";

}
