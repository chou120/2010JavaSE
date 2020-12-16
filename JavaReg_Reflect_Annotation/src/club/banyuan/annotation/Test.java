package club.banyuan.annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author sanye
 * @version 1.0
 * @date 2020/12/16 4:09 下午
 */
public class Test {

  public static void main(String[] args) throws NoSuchFieldException, NoSuchMethodException {
    Class<Person> personClass = Person.class;

    Field name = personClass.getDeclaredField("name");
    name.setAccessible(true);

    //获取的是字段上面的注解
    MyAnnotation annotation = name.getAnnotation(MyAnnotation.class);

    System.out.println("----"+annotation.value());

    Method show = personClass.getDeclaredMethod("show");

    MyAnnotation annotation1 = show.getAnnotation(MyAnnotation.class);

    System.out.println("show方法上面的值为:"+annotation1.value());


  }
}
