package club.banyuan.byteStream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @author sanye
 * @version 1.0
 * @date 2020/12/8 2:37 下午
 */
public class Demo2 {

  public static void main(String[] args) {
    OutputStream outputStream = null;//从内存中输出到外部介质中

    File  file2=new  File("/Users/sanye/2010/2010JavaSE/JavaFile/src/1.txt");
   /* try {

      String  [] str=new  String[20];
      for (int i = 0; i < str.length; i++) {
        str[i]="数据"+i;
      }

      if(!file2.exists()){
        file2.createNewFile();
      }
      outputStream=new FileOutputStream(file2,true);
      for (int i = 0; i < str.length; i++) {
           outputStream.write(str[i].getBytes());
           if((i+1)%5==0){
             outputStream.write("\n".getBytes());
           }else{
             outputStream.write(",".getBytes());
           }
      }
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      try {
        if(outputStream!=null){
          outputStream.close();
        }
      } catch (IOException e) {
        e.printStackTrace();
      }
    }*/
    //需求:将1.txt中的所有的数据读取出来,并且存放到集合中
    List<String>  list=new ArrayList<>();
    try (InputStream inputStream = new FileInputStream(file2)){
      final byte[] bytes = inputStream.readAllBytes();
       String s = new String(bytes);
       String[] split = s.split("\n");
      for (String s1 : split) {
        final String[] split1 = s1.split(",");
        for (String s2 : split1) {
          list.add(s2);
        }
      }
      System.out.println(list);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
