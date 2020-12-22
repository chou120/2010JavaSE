import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import org.junit.Test;

public class Main {

  public static void main(String[] args) {
    List<Provider> providers = new ArrayList<>();
    providers.add(new Provider(1, "a", "a1"));
    providers.add(new Provider(2, "b", "b1"));
    providers.add(new Provider(3, "ab", "ab1"));
    providers.add(new Provider(4, "c", "ac1"));
    providers.add(new Provider(5, "d", "a1"));

    Provider query = new Provider(0, "", "a");

    List<Provider> filterList = getProvidersRefine(providers, query);
    System.out.println(filterList);

    query.setName("a");
    query.setDesc("");
    filterList = getProvidersRefine(providers, query);
    System.out.println(filterList);

    query.setName("");
    query.setDesc("");
    filterList = getProvidersRefine(providers, query);
    System.out.println(filterList);

    query.setName("a");
    query.setDesc("b");
    filterList = getProvidersRefine(providers, query);
    System.out.println(filterList);
  }

  @Test
  public void getUsersTest() {
    List<User> users = new ArrayList<>();
    users.add(new User(1, "a", "a1"));
    users.add(new User(2, "b", "b1"));
    users.add(new User(3, "ab", "ab1"));
    users.add(new User(4, "c", "ac1"));
    users.add(new User(5, "d", "a1"));

    User query = new User(0, "", "a");

    List<User> filterList = getUsersRefine(users, query);
    System.out.println(filterList);

    query.setName("a");
    query.setPwd("");
    filterList = getUsersRefine(users, query);
    System.out.println(filterList);

    query.setName("");
    query.setPwd("");
    filterList = getUsersRefine(users, query);
    System.out.println(filterList);

    query.setName("a");
    query.setPwd("b");
    filterList = getUsersRefine(users, query);
    System.out.println(filterList);
  }

  private static List<Provider> getProviders(List<Provider> providers, Provider query) {
    List<Provider> filterList = providers.stream().filter(t -> {
      if (query.getName().trim().isEmpty()) {
        return true;
      } else {
        return t.getName().contains(query.getName());
      }
    }).filter(t -> {
      if (query.getDesc().trim().isEmpty()) {
        return true;
      } else {
        return t.getDesc().contains(query.getDesc());
      }
    }).collect(Collectors.toList());
    return filterList;
  }


  private static List<Provider> getProvidersRefine(List<Provider> providers, Provider query) {
    List<Provider> filterList = providers.stream()
        .filter(containsPredict(query, "getName"))
        .filter(containsPredict(query, "getDesc"))
        .collect(Collectors.toList());
    return filterList;
  }

  private static List<User> getUsersRefine(List<User> providers, User query) {
    List<User> filterList = providers.stream()
        .filter(containsPredict(query, "getName"))
        .filter(containsPredict(query, "getPwd"))
        .collect(Collectors.toList());
    return filterList;
  }

  private static <T> Predicate<T> containsPredict(T query, String methodName) {
    return t -> {
      Class<?> aClass = query.getClass();
      try {
        Method declaredMethod = aClass.getDeclaredMethod(methodName);
        if (((String) (declaredMethod.invoke(query))).trim().isEmpty()) {
          return true;
        } else {
          return ((String) (declaredMethod.invoke(t)))
              .contains(((String) (declaredMethod.invoke(query))));
        }
      } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
        e.printStackTrace();
      }
      return true;
    };
  }

  @Test
  public void callStaticMethod()
      throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
    Method staticMethod = Provider.class.getDeclaredMethod("staticMethod");
    staticMethod.invoke(null);
  }


  @Test
  public void callMethodTest()
      throws Exception {
    callMethod(new Provider(1, "12345", ""), "getName");
  }

  public void callMethod(Provider provider, String methodName)
      throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
    System.out.println(provider.getName());

    // provider.(methodName??)

    // Class<? extends Provider> aClass = provider.getClass();

    // System.out.println(aClass == Provider.class);

    // Method对象，保存方法名称，方法的入参，入参的参数类型，返回值类型
    Method declaredMethod = Provider.class.getDeclaredMethod(methodName);

    // 实例方法 调用，需要由 对象.方法名(入参)
    // 方法名.invoke(对象，入参)
    declaredMethod.invoke(provider);

    Method[] declaredMethods = Provider.class.getDeclaredMethods();
    for (Method method : declaredMethods) {
      Parameter[] parameters = method.getParameters();
    }


  }
}
