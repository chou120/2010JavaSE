package club.banyuan;

import java.lang.reflect.Method;

public class GenericTest<T> {

  public T test() {
    System.out.println("test");
    return null;
  }

  public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
    GenericTest<String> a = new GenericTest<>();

    Method[] declaredMethods = a.getClass().getDeclaredMethods();
    for (Method declaredMethod : declaredMethods) {
      System.out.println(declaredMethod.getName());
      System.out.println(declaredMethod.getGenericReturnType());
      System.out.println(declaredMethod.getReturnType());
      System.out.println(declaredMethod.getGenericReturnType().getTypeName());
      System.out.println("======");
    }
  }
}
