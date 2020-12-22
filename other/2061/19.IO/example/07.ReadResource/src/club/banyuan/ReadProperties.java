package club.banyuan;

import java.io.IOException;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;

public class ReadProperties {

  public static void main(String[] args) throws IOException {
    Properties properties = new Properties();
    // properties.load(
    //     ReadProperties.class.getResourceAsStream("/app.properties")
    // );

    properties.load(
        ReadProperties.class.getResourceAsStream("/app.properties")
    );
    String length = properties.getProperty("length");

    Set<Entry<Object, Object>> entries = properties.entrySet();
    for (Entry<Object, Object> entry : entries) {
      System.out.println(entry.getKey());
      System.out.println(entry.getValue());
    }

    int[] intArr = new int[Integer.parseInt(length)];
    System.out.println(length);
  }
}
