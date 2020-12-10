package club.banyuan.properties;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

/**
 * @author sanye
 * @version 1.0
 * @date 2020/12/10 9:19 上午
 */
public class MyProperties {

  public static void main(String[] args) {
    Properties properties = new Properties();
    //本类是对一种特殊的文件进行操作的工具类,这个特殊的文件是以   xxx.properties 为结尾的文件
    /**
     * 在后期很多陪的一些路径等都存放在这文件里面
     */
    /*try (FileInputStream fileInputStream = new FileInputStream(
        new File("JavaFile/src/club/banyuan/properties/app.properties"))) {
      properties.load(fileInputStream);

      System.out.println(properties.get("zhifubao"));
      System.out.println(properties.get("password"));

    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }*/
    properties.setProperty("root", "zhou");
    properties.setProperty("password", "zhou");
    properties.setProperty("address", "如果是汉字");
//
//    try (FileWriter fileWriter = new FileWriter(
//        new File("JavaFile/src/club/banyuan/properties/app.properties"))) {
//        properties.store(fileWriter,"author:三爷");
//
//    } catch (IOException e) {
//      e.printStackTrace();
//    }

  }
}
