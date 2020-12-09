package club.banyuan.charStream;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

/**
 * @author sanye
 * @version 1.0
 * @date 2020/12/9 1:37 下午
 */
public class Demo {

  public static void main(String[] args) {
    File file = new File("JavaFile/src/student.txt");
    if (!file.exists()) {
      try {
        file.createNewFile();
      } catch (IOException e) {
        e.printStackTrace();
      }
    }

    try {
//      Writer fileWriter = new FileWriter(file,true);
//      fileWriter.write("萨达撒无");
      // fileWriter.flush();  //刷新是缓存    将缓存中的数据刷新到硬盘中
      // fileWriter.close(); //java.io.IOException: Stream closed
      // fileWriter.write("恩几千万就能看到可能就去");
      //   fileWriter.flush();
//
//      fileWriter.append("追加一个对象").append("21").append('4');
//      fileWriter.flush();
//      fileWriter.close();

      //读取出来
      Reader reader = new FileReader(file);
      char[] chars = new char[(int) file.length()];  // 1.txt

      int read = reader.read();//当read不等于-1 就表示文件没有结束
      int key = 0;
      while (read != -1) {
        chars[key++] = (char) read;
        read = reader.read();
      }

      String s = new String(chars, 0, key);
      System.out.println("最终的内容为:" + s);
      reader.close();

    } catch (IOException e) {
      e.printStackTrace();
    }

  }
}
