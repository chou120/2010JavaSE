package club.banyuan.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author sanye
 * @version 1.0
 * @date 2020/12/9 11:58 上午
 */
public class MyProperties {

    static {
      InputStream resourceAsStream = MyProperties.class
          .getResourceAsStream("/Users/sanye/2010/2010JavaSE/JavaProject/resource/app.properties");
      Properties  properties=new Properties();
      try {
        properties.load(resourceAsStream);

      } catch (IOException e) {
        e.printStackTrace();
      }
    }
}
