package club.banyuan.properties;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author sanye
 * @version 1.0
 * @date 2020/12/10 9:54 上午
 */
public class FilePath2 {

  public static void main(String[] args) throws IOException {


    // 获取当前程序的类路径

    // 当前类的所在路径
    System.out.println(FilePath2.class.getResource("").getPath());

    // 获取classpath的根路径
    System.out.println(FilePath2.class.getResource("/").getPath());

    // 获取classpath的路径，通过类加载器的相对路径来获取classpath
    System.out.println(FilePath2.class.getClassLoader().getResource("").getPath());

    //默认 是在当前模块的src下面
    InputStream resourceAsStream = FindFilePath.class
        .getClassLoader().getResourceAsStream("app.properties");

    // 不支持使用 / 获取路径
    // System.out.println(ClassPathDemo.class.getClassLoader().getResource("/").getPath());

    // /Users/liyi/works/repos/banyuan/javase-2061/19.IO/example/07.ReadResource/src/club/banyuan/ClassPathDemo.java

    // 获取class文件本身
    System.out.println(FilePath2.class.getResource("FilePath2.class").getPath());

    // 获取classpath的根路径
    System.out.println(FilePath2.class.getResource("/club/banyuan/properties/FilePath2.class").getPath());

    // 获取classpath的路径，通过类加载器的相对路径来获取classpath
    System.out.println(FilePath2.class.getClassLoader().getResource("club/banyuan/properties/FilePath2.class").getPath());

    File file = new File(FilePath2.class.getClassLoader().getResource("test.json").getPath());
    System.out.println(file.getAbsolutePath());
    System.out.println(file.exists());

    FileWriter fileWriter = new FileWriter(file);
    fileWriter.write("12345");
    fileWriter.flush();
    fileWriter.close();





  }


}
