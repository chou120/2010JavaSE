package club.fileHomework.Homework1;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author sanye
 * @version 1.0
 * @date 2020/12/8 3:46 下午
 */
public class TestFile {

  private static final String FILE = "/Users/sanye/2010/2010JavaSE";

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    File file = new File(FILE); //默认的在当前项目的目录下

    while (true) {
      System.out.println("请输入命令:");
      String s = scanner.nextLine();
      String[] s1 = s.split(" ");
      // System.out.println(Arrays.toString(s1));
      //判断多个空格问题
      List<String> collect = Stream.of(s1).filter(string -> !string.equals("")).map(String::trim)
          .collect(Collectors.toList());

      switch (collect.get(0)) {
        case "ls": //数据校验没有做  你们有时间就去补全 数据校验和自定义异常
          ls(collect, file);
          break;
        case "cp":
          //TODO
          break;
        case "rm":
          System.out.println("rm");
          file=new File(collect.get(1));
          rm(file);
          break;
        case "cat":
          //TODO
          break;
        default:
          throw new RuntimeException("命令行参数不合法....");

      }

    }
  }

  /**
   * 删除 分为两步  1.直接删除文件  2.是文件夹,如果文件夹为空直接删除,如果不为空就删除该文件夹下面的文件在删除文件夹
   *
   * @param file
   */
  private static void rm(File file) {

      if(file.isDirectory()){
         File[] files = file.listFiles();
        for (File file1 : files) {
          if(file1.isFile()){
            file1.delete();//删除文件夹
          }else{
            rm(file1);
          }
        }

        file.delete();//删除父文件夹
      }else {
        file.delete();//删除文件
      }



  }

  private static void ls(List<String> collect, File file) {

    switch (collect.size()) {
      case 1:  //ls
        //实现当前目录下的所有的文件夹及文件名称
        File[] files = file.listFiles();
        for (int i = 0; i < files.length; i++) {
          if ((i + 1) % 5 == 0) {
            System.out.println();
          }
          System.out.print(files[i].getName() + "\t\t");
        }
        System.out.println();  //起换行作用
        break;
      case 2:

        //如果长度为2 考虑三种情况   ls  + 文件夹  、 ls  + 文件 、 ls  -l
        String s = collect.get(1);
         File newFile = new File(s);

        if (newFile.isDirectory()) {
            System.out.println(calFile(newFile));
            break;
          } else if (newFile.isFile()) { //如果是文件
            System.out.println(isFile(newFile).toString());
            break;
          } else if (s.equals("-l")) {  //如果传递过来的是命令行参数
            // System.out.println(file);
            System.out.println(showAll(file));
            break;
          }

      case 3:
        //如果长度为3  会存在两种情况  ls -l +文件夹   ls -l +文件
        String s1 = collect.get(2);
        File file1 = new File(s1);
        if(file1.isDirectory()){
          System.out.println(calFile(file1));
        }else{
          System.out.println(isFile(file1));
        }
        break;
      default:
        throw new RuntimeException("输入的命令行不合法....");

    }
  }

  //显示所有当前目录下面所有文件及文件夹
  private static String showAll(File file) {

    return calFile(file);
  }

  /**
   * 对指定文件夹进行操作
   * @param file
   * @return
   */
  private static String calFile(File file) {
    System.out.println("--->");
    StringBuilder str = new StringBuilder();
    if (file.isDirectory()) {
      File[] files2 = file.listFiles();
      for (int j = 0; j < files2.length; j++) {
        if (files2[j].isDirectory()) {
          str.append(strContact(files2[j]).toString());
        }
        if (files2[j].isFile()) {
          str.append(isFile(files2[j]).toString());
        }
      }
    }
    return str.toString();
  }

  /**
   * 判断是否是文件
   * @param file
   * @return
   */
  private static StringBuffer isFile(File file) {
    return strContact(file);
  }

  /**
   * 字符串拼接
   * @param file
   * @return
   */
  private static StringBuffer strContact(File file) {
    StringBuffer str = new StringBuffer();

    if (file.isHidden()) {
      //如果隐藏
      str.append("-\t\t");
    } else {
      str.append("d\t\t");
    }
    if (file.isDirectory()) {
      str.append("0\t\t");
    } else {
      //如果是文件就拼接文件大小
      str.append(file.length() + "\t\t");
    }

    long end = file.lastModified(); //最后一次修改文件夹的时间
    //写一个计算时间的方法
    String date = calumniateDate(end);
    str.append(date + "\t\t");
    str.append(file.getName() + "\n");

    return str;
  }


  //对时间进行格式转换
  private static String calumniateDate(long time) {
    Date date = new Date(time);
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    return simpleDateFormat.format(date);
  }
}
