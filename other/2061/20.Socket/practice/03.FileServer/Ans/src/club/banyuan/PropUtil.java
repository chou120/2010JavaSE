package club.banyuan;

import java.io.IOException;
import java.util.Properties;

public class PropUtil {


  private static Properties properties;

  static {
    properties = new Properties();
    try {
      properties.load(PropUtil.class.getResourceAsStream("/server.properties"));
    } catch (IOException e) {
      System.out.println("读取配置文件失败");
      System.exit(-1);
    }
  }

  public static String getProp(String name) {
    return properties.getProperty(name);
  }

  public static int getIntProp(String name) {
    return Integer.parseInt(getProp(name));
  }
}
