package club.banyuan.serverFile;

import java.io.BufferedInputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

/**
 * @author sanye
 * @version 1.0
 * @date 2020/12/10 7:23 下午
 */
public class FileClient {


  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    try {
      while (true) {

        showAllFile();

        Socket socket = new Socket(InetAddress.getLocalHost(), 1211);

        OutputStream outputStream = socket.getOutputStream();
        BufferedWriter bufferedWriter = new BufferedWriter(
            new OutputStreamWriter(outputStream));

        System.out.println("请输入要下载的文件名:");
        String fileName = scanner.nextLine();
        bufferedWriter.write(fileName);
        bufferedWriter.flush();
        //关闭了输入流,而且是单向关闭  所以不可以再去写输入到socket数据包中
        socket.shutdownOutput();

    /*   bufferedWriter.write("asdaksdhsa");
       bufferedWriter.flush();
    */
        System.out.println("socket是否还是在连接中..." + socket.isConnected());

        InputStream inputStream = socket.getInputStream();
        BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);

        int available = bufferedInputStream.available(); //获取数据流的字节长度
        byte[] bytes = new byte[1024000]; //动态获取长度

        int read = bufferedInputStream.read();
        int key = 0;
        while (read != -1) {
          bytes[key++] = (byte) read;
          read = bufferedInputStream.read();
        }

        File file = new File("/Users/sanye/" + fileName);
        if (!file.exists()) {
          file.createNewFile();
        }
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        fileOutputStream.write(bytes);
        fileOutputStream.close();
        bufferedInputStream.close();
        inputStream.close();
        socket.close();
      }
    } catch (IOException e) {
      e.printStackTrace();
    }


  }

  private static void  showAllFile(){
     String filePath = ProUtil.getFilePath();
     File  file=new  File(filePath);
     File[] files = file.listFiles();
    for (File file1 : files) {
      if(file1.isFile()){
        String substring = file1.getName();
        System.out.println("文件名为:"+substring+",\t文件长度为:"+file1.length());

      }
    }
  }

}
