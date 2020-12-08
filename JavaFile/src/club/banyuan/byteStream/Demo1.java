package club.banyuan.byteStream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;

/**
 * @author sanye
 * @version 1.0
 * @date 2020/12/8 2:37 下午
 */
public class Demo1 {

  public static void main(String[] args) {
    InputStream inputStream = null;  //从外部介质中读取到内存中
    OutputStream outputStream = null;//从内存中输出到外部介质中

    File file=new File("/Users/sanye/2010/2010JavaSE/JavaFile/src/1.txt");

    try {
      inputStream =new   FileInputStream(file);
      byte [] bytes=new byte[(int)(file.length())];
     // inputStream.read(bytes); //一次性读取所有 内容存放到数组中
      int read = inputStream.read();
      int   key=0;
      while (read!=-1){  //一个个读取
        bytes[key++]=(byte)read;
        read = inputStream.read();
      }

      String s = new String(bytes);
      System.out.println("文件内容为:"+ s);

      File  file2=new  File("/Users/sanye/2010/2010JavaSE/JavaFile/src/2.txt");
      outputStream=new FileOutputStream(file2,true);
     // outputStream.write(s.getBytes());

      outputStream.write("\n".getBytes());
      final byte[] bytes1 = s.getBytes();
      int   count=0;
      while(count<bytes1.length){
        outputStream.write(bytes1[count++]);
      }
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      try {
        if(inputStream!=null){
          inputStream.close();  //文件流操作完毕之后,将文件流进行关闭
        }
        if(outputStream!=null){
          outputStream.close();
        }
      } catch (IOException e) {
        e.printStackTrace();
      }
    }


  }
}
