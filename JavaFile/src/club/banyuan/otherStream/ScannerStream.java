package club.banyuan.otherStream;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

/**
 * @author sanye
 * @version 1.0
 * @date 2020/12/9 2:21 下午
 */
public class ScannerStream {

  public static void main(String[] args) {

//    InputStream in = System.in;
//    //把输入流放进去的目的  从键盘获取数据
//    Scanner scanner = new Scanner(in);
//    System.out.println(scanner.next());
//    scanner.close();

//    PrintStream out = System.out;
//    out.print("张三");   ----->>>>>   System.out.print();

    try {
      //转换流  将字节流转换成字符流
      InputStreamReader inputStreamReader = new InputStreamReader(
          new FileInputStream(new File("JavaFile/src/student.txt")));

      OutputStreamWriter  outputStreamWriter=new OutputStreamWriter(
          new FileOutputStream(new File("JavaFile/src/student.txt")));


    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
    //1.scanner  类似  获取一个键盘输入
    BufferedReader bufferedReader = new BufferedReader(
        new InputStreamReader(
            //作用  获取一个输入流,整个程序进入了阻塞状态
            System.in));  //语法熟悉

    String  str=null;
    try {
      System.out.println("请输入一个数据:");
      str=bufferedReader.readLine();
      System.out.println("您输入的内容是:"+str);
      bufferedReader.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
    //2.写入文件
    PrintWriter  printWriter=null;
    try {
      printWriter=new PrintWriter(
          //文件字符流  将文件字符流包装成打印字符流
          new FileWriter(new File("JavaFile/src/student.txt"),true)
      );

      printWriter.print(str);  //利用打印输出 方式  写入到目标中
      printWriter.close();

    } catch (IOException e) {
      e.printStackTrace();
    }


  }
}
