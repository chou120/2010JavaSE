package club.banyuan.serverFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author sanye
 * @version 1.0
 * @date 2020/12/10 7:25 下午
 */
public class ProUtil {

  private  static  final Properties  properties=new Properties();
  //程序启动就开始加载文件
  static {
     InputStream resourceAsStream = ProUtil.class.getClassLoader().getResourceAsStream(
         "app.properties");

    try {
      properties.load(resourceAsStream);

    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public static  String  getFilePath(){  //获取key
    return (String)properties.get("path");
  }


  public static void main(String[] args) {
    System.out.println(getFilePath());
  }

}
