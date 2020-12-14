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
 * @date 2020/12/11 1:36 下午
 */
public class Test {

  public static void main(String[] args) {
    try (ServerSocket socket = new ServerSocket(9001)) {
      while (true){
        Socket socket1 = socket.accept();
        InputStream inputStream = socket1.getInputStream();
        BufferedReader bufferedReader =
            new BufferedReader(new InputStreamReader(inputStream));

        //GET / HTTP/1.1    https:
        String line = bufferedReader.readLine();
        String url = line.split(" ")[1];
        System.out.println("路径" + url);
        while(line!=null){
          System.out.println(line);
          line = bufferedReader.readLine();
        }

        File file = new File("/Users/sanye/2010/2010JavaSE/Manager/doc/pages" + url);

        FileInputStream fileInputStream = new FileInputStream(file);
        OutputStream outputStream = socket1.getOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(outputStream);

        //状态码: 后端发送给前端 如果发送成功 200  400  404  500
        dataOutputStream.writeBytes("HTTP/1.1 200 ok\n");
        //告诉浏览器数据的长度
        dataOutputStream.writeBytes("Content-Length: "+fileInputStream.available()+"\n");

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

        dataOutputStream.write(fileInputStream.readAllBytes());
        dataOutputStream.flush();
        socket1.shutdownOutput();  //关闭写入流


      }

    } catch (IOException e) {
      e.printStackTrace();
    }

  }
}
