package club.banyuan.demo;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author sanye
 * @version 1.0
 * @date 2020/12/8 1:41 下午
 */
public class MyFile {

  public static void main(String[] args) {
    File file = new File("JavaFile/src/2.txt");  //会去当前项目下面去找
    if (!file.exists()) {
      try {
        file.createNewFile();
      } catch (IOException e) {
        e.printStackTrace();
      }
      // throw  new  RuntimeException("文件不存在...");
    }

//    System.out.println(file.getAbsolutePath());
//    System.out.println(file.getPath());

    final long length = file.length(); //表示是文件内容大小
    System.out.println(length);  //一个汉字在txt文档中占3个字节  一个字母占一个字节

    file = new File("video");
    boolean mkdir = file.mkdir();
    if (mkdir && file.isDirectory()) {
      System.out.println("创建成功了...." + mkdir);
    }
    File file1 = new File(file, "student.txt");
    if (!file1.exists()) {
      try {
        file1.createNewFile();
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
    System.out.println(file1.isFile());
    //file1.setWritable(false);
    file1.setReadable(true);//设置为只读
    // file1.delete();

    System.out.println(">>>>>>>>>>>>>>>>>>>>");

    File file2 = new File("/Users/sanye/2010/2010JavaSE");
//    final String[] list = file2.list();
////    for (String s : list) {
////      System.out.println(s);
////    }

//    final File[] files = file2.listFiles();
//    for (File file3 : files) {
//      System.out.println(file3.toString()+"------"+file3.getName());
//    }

    File[] files = file2.listFiles((dir, name) -> {
      if (name.endsWith(".md")) {
        return true;
      }
      return false;
    });

    for (File file3 : files) {
      System.out.println("---------------" + file3);
    }
    System.out.println(file1.renameTo(new File("红花会.txt")));
    //找到所有模块中的md文件,并且将找到的文件进行收集起来
    List<File> fileList = new ArrayList<>();
    searchFile(file2, fileList);
    System.out.println("收集之后的文件夹为:");
    fileList.stream().forEach(System.out::println);

  }
  //用来收集文件的方法
  public static void searchFile(File file, List<File> list) {
    if (file.isFile()) {
      if (file.getName().endsWith(".md")) {
        //表示收集到了指定文件
        list.add(file);
      }
    } else if (file.isDirectory()) {
      File[] files = file.listFiles(); //收集了该文件夹下的所有文件(文件+文件夹)
      for (File file1 : files) {
          searchFile(file1,list);
      }
    }
  }
}
