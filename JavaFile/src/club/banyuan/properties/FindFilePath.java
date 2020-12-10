package club.banyuan.properties;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Properties;

/**
 * @author sanye
 * @version 1.0
 * @date 2020/12/10 9:32 上午
 */
public class FindFilePath {

  public static void main(String[] args) throws IOException {

//    File file = new File("JavaFile/src/club/banyuan/properties/app2.properties");
//    FileInputStream resourceAsStream=new FileInputStream(file);

      InputStream resourceAsStream = FindFilePath.class
          .getClassLoader().getResourceAsStream("app.properties");
    //  getResourceAsStream  需要在FindFilePath.class相同 模块中去寻找  指定的文件  具体的包+文件名
    //默认的路径是在src下面

    Properties properties = new Properties();
    properties.load(resourceAsStream);
    System.out.println(properties);



  }
}

