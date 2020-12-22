package club.banyuan.video;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class MyProperties {

  private Map<String, String> map = new HashMap<>();


  // key=value \n
  // key1=value
  public void load(InputStream inputStream) {
    try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
      String line = reader.readLine();
      while (line != null) {
        String[] split = line.split("=");
        map.put(split[0], split[1]);
        line = reader.readLine();
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public String getProperty(String key) {
    return map.get(key);
  }

  public static void main(String[] args) {
    InputStream resourceAsStream = MyProperties.class.getResourceAsStream("/video.properties");
    MyProperties my = new MyProperties();
    my.load(resourceAsStream);
    String property = my.getProperty("store.file.path");
    System.out.println(property);
  }
}
