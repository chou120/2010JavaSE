package club.banyuan.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author sanye
 * @version 1.0
 * @date 2020/12/16 2:44 下午
 */
public class ReflectDemo {
  /**
   * 反射:
   */

  public static void main(String[] args) throws ClassNotFoundException {
    ClassLoader classLoader = Person.class.getClassLoader();
    Class<?> aClass = classLoader.
        loadClass(
            "club.banyuan.reflect.Person");
    //System.out.println(aClass);

    Class<?> aClass1 = Class.forName("club.banyuan.reflect.Person");
   // System.out.println(aClass1);

    Class<Person> personClass = Person.class;
   // System.out.println(personClass);

    //class 文件对象
    Method[] methods = personClass.getMethods();

//    for (Method method : methods) {
//      System.out.println(method.getName());
//    }

    try {

      Method show2= personClass.getDeclaredMethod("show",String.class);
      show2.setAccessible(true);  //私有化方法要访问的话 加这句话


       //personClass.getMethod("show", String.class);
      //show2.setAccessible(true);  //暴力访问

      System.out.println(show2);

      Field name = personClass.getDeclaredField("name");
      Constructor<Person> constructor = personClass.getConstructor(); //获取无参构造
      Person person = constructor.newInstance();
      person.setName("王五");

      Constructor<Person> constructor1 = personClass.getConstructor(String.class, String.class);
      Person person1 = constructor1.newInstance("张三","李四");
      System.out.println(person1);

      //  动态代理         就是说在执行目标方法执行  优先去做指定另一个方法    b() a()

      //执行目标方法
     // show2.invoke(person, "你是个啥...");

      //System.out.println(name);
    } catch (NoSuchMethodException e) {
      e.printStackTrace();
    } catch (NoSuchFieldException e) {
      e.printStackTrace();
    } catch (IllegalAccessException e) {
      e.printStackTrace();
    } catch (InstantiationException e) {
      e.printStackTrace();
    } catch (InvocationTargetException e) {
      e.printStackTrace();
    }


  }
}
