package club.banyuan.xml;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author sanye
 * @version 1.0
 * @date 2020/12/9 9:07 上午
 */
public class XMLDemo {

  /**
   * XML:可扩展语言
   * @param args
   */

  public static void main(String[] args) {
    File file = new File("JavaFile/info.xml");
   try( InputStream  inputStream=new FileInputStream(file)) {
      byte[] bytes = inputStream.readAllBytes();
      String s = new String(bytes);
     System.out.println(s);

   } catch (IOException e) {
     e.printStackTrace();
   }
  }

}
