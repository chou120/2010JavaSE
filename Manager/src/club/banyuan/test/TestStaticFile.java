package club.banyuan.test;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author sanye
 * @version 1.0
 * @date 2020/12/11 11:11 上午
 */
public class TestStaticFile {

  public static void main(String[] args) {
    try (ServerSocket serverSocket = new ServerSocket(9090)) {
      while (true) {
        Socket accept = serverSocket.accept();
        OutputStream outputStream = accept.getOutputStream();

        InputStream inputStream = accept.getInputStream();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String line = bufferedReader.readLine();

        System.out.println("传递过来的数据为:" + line);

        String url = line.split(" ")[1];

        DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
        File file = new File("/Users/sanye/2010/2010JavaSE/Manager/doc/pages/" + url);
        FileInputStream fileInputStream = new FileInputStream(file);

        //告诉前端页面一个响应状态码
        dataOutputStream.writeBytes("HTTP/1.1 200 OK\n");
        //告诉前端页面需要写入的数据长度
        dataOutputStream.writeBytes("Content-Length: " + fileInputStream.available() + "\n");

        /**
         * 此处的url中包含了html  和css  的一些静态的资源
         *    但是静态资源在前端页面的渲染方式又不一样  所以在这里做个判断
         */
        if (url.endsWith(".html")) {
          dataOutputStream.writeBytes("Content-Type: text/html; charset=utf-8;\n");
        } else if (url.endsWith(".css")) {
          dataOutputStream.writeBytes("Content-Type: text/css; charset=utf-8;\n");
        }
        //使用换行符对响应头和文件数据进行分开  不然文件数据没法显示在页面上
        dataOutputStream.writeBytes("\n");
        //将读取出来的数据写到前端页面
        dataOutputStream.write(fileInputStream.readAllBytes());
        dataOutputStream.flush();
        // fileInputStream.close();
        // accept.close();
        accept.shutdownOutput();
      }
    } catch (IOException e) {
      e.printStackTrace();
    }


  }
}
