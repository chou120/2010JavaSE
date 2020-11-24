package club.banyuan.interfaceDemo2;

/**
 * @author sanye
 * @version 1.0
 * @date 2020/11/24 11:25 上午
 */
public interface UserDao {

  public static final String ADDRESS = "撒啥时候";  //接口里面只有静态常量

  void login(String name);

}
