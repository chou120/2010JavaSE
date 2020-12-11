package club.banyuan.serverFile;

import com.alibaba.fastjson.JSONObject;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author sanye
 * @version 1.0
 * @date 2020/12/10 7:22 下午
 */
public class FileServer {

  //如果一旦建立连接就把所有的文件读取出来发送给客户端
  public static void main(String[] args) throws IOException {

    ServerSocket serverSocket = new ServerSocket(1211);
    Socket accept = null;
    while (true) {
      try {
        accept = serverSocket.accept();
        InputStream inputStream = accept.getInputStream();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

        int line = bufferedReader.read(); //获取客户端发送过来的数据
        char[] chars = new char[1024];
        int key = 0;
        while (line != -1) {
          chars[key++] = (char) line;
          line = bufferedReader.read();
        }
        String s = new String(chars, 0, key);
        System.out.println("客户端传过来的数据为:" + s);

        OutputStream outputStream = accept.getOutputStream();
        BufferedOutputStream bufferedWriter = new BufferedOutputStream(outputStream);
        //BufferedWriter bufferedWriter=new BufferedWriter(new OutputStreamWriter(outputStream));
        if(s!=null){
          byte[] files = getFiles(s);
          System.out.println("文件长度为:"+files.length);
          if(files!=null){
            bufferedWriter.write(files);
            bufferedWriter.flush();
          }else {
            bufferedWriter.write("没有此文件...".getBytes());
            bufferedWriter.flush();
          }
        }else {
          bufferedWriter.write("接受数据不能为空...".getBytes());
          bufferedWriter.flush();
        }
        outputStream.close();

        //accept.close();

      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }





  public static byte[] getFiles(String fileStr) {

    File file = new File(ProUtil.getFilePath()); //这是文件夹
    File[] files = file.listFiles(); //只需要文件
    for (File file1 : files) {
      if (file1.isFile() && file1.getName().equals(fileStr)) {

        try (BufferedInputStream bufferedReader = new BufferedInputStream(
            new FileInputStream(file1 ))) {
            byte[] bytes=new byte[(int)file1.length()];
           int read = bufferedReader.read();
           int key=0;
           while (read!=-1){
             bytes[key++]=(byte) read;
             read = bufferedReader.read();
           }
           return bytes;
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
    }
    return null;
  }
}
