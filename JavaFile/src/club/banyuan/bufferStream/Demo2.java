package club.banyuan.bufferStream;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author sanye
 * @version 1.0
 * @date 2020/12/9 2:11 下午
 */
public class Demo2 {

  public static void main(String[] args) {

    //这种写法自动关闭流 不需要手动关闭
//    try (BufferedWriter bufferedWriter = new BufferedWriter(
//        new FileWriter(new File("JavaFile/src/student.txt"),true))) {
//
//      bufferedWriter.write("张三丰");
//      bufferedWriter.newLine();
//      bufferedWriter.write("张三丰2");
//      bufferedWriter.newLine();
//      bufferedWriter.write("张三丰3");
//      bufferedWriter.newLine();
//
//
//    } catch (IOException e) {
//      e.printStackTrace();
//    }

    try (BufferedReader bufferedReader = new BufferedReader(
        new FileReader(new File("JavaFile/src/student.txt")))) {

      String s = bufferedReader.readLine();
      while (s != null) {
        System.out.println(s);
        s = bufferedReader.readLine();
      }

    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }

    /**
     * 字节流    输入字节流   输出字节流
     *        缓冲输入字节流   缓冲输出字节流
     *
     * 字符流     输入字符流   输出字符流
     *        缓冲...
     *
     */


  }
}
