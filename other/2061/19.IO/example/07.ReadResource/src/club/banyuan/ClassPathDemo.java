package club.banyuan;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ClassPathDemo {

  public static void main(String[] args) throws IOException {
    // 获取当前程序的类路径

    // 当前类的所在路径
    System.out.println(ClassPathDemo.class.getResource("").getPath());

    // 获取classpath的根路径
    System.out.println(ClassPathDemo.class.getResource("/").getPath());

    // 获取classpath的路径，通过类加载器的相对路径来获取classpath
    System.out.println(ClassPathDemo.class.getClassLoader().getResource("").getPath());
    // 不支持使用 / 获取路径
    // System.out.println(ClassPathDemo.class.getClassLoader().getResource("/").getPath());

    // /Users/liyi/works/repos/banyuan/javase-2061/19.IO/example/07.ReadResource/src/club/banyuan/ClassPathDemo.java

    // 获取class文件本身
    System.out.println(ClassPathDemo.class.getResource("ClassPathDemo.class").getPath());

    // 获取classpath的根路径
    System.out.println(ClassPathDemo.class.getResource("/club/banyuan/ClassPathDemo.class").getPath());

    // 获取classpath的路径，通过类加载器的相对路径来获取classpath
    System.out.println(ClassPathDemo.class.getClassLoader().getResource("club/banyuan/ClassPathDemo.class").getPath());

    File file = new File(ClassPathDemo.class.getClassLoader().getResource("test.json").getPath());
    System.out.println(file.getAbsolutePath());
    System.out.println(file.exists());

    FileWriter fileWriter = new FileWriter(file);
    fileWriter.write("12345");
    fileWriter.flush();
    fileWriter.close();
  }
}
