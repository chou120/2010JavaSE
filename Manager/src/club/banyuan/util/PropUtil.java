package club.banyuan.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author sanye
 * @version 1.0
 * @date 2020/12/11 10:38 上午
 */
public class PropUtil {

  private static Properties properties;

  static {
    properties = new Properties();
    try (InputStream resourceAsStream = PropUtil.class.getResourceAsStream("/app.properties")) {
      properties.load(resourceAsStream);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public static String getProp(String key) {
    return properties.getProperty(key);
  }


  public static void main(String[] args) {
    System.out.println(properties);
  }

}
