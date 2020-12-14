package club.banyuan.test;

import club.banyuan.request.Request;
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
        //读取一个请求
        InputStream inputStream = accept.getInputStream();

        Request request = parse(inputStream);

         String url = request.getUrl();
        if(url.startsWith("/server")){
          System.out.println("欢迎进入前端请求数据操操作...");  // 前端传递过来的数据拿到然后跟后端进行对比
          System.out.println("前端传递过来的数据为:"+request.getData());  //

          DataOutputStream  dataOutputStream=new DataOutputStream(outputStream);

          dataOutputStream.writeBytes("HTTP/1.1 200 OK\n");
          dataOutputStream.writeBytes("\n");
          dataOutputStream.flush();

        }else{
           //如果不是以/server开头 那么就是应该加载静态文件
          DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
          File file = new File("/Users/sanye/2010/2010JavaSE/Manager/doc/pages/" + url);  //404.html
          //加载html文件的时候要考虑静态文件在doc里面能不能找到,如果找不到就显示404.html
          if(!file.exists()){
             file = new File("/Users/sanye/2010/2010JavaSE/Manager/doc/pages/" + "404.html");
          }

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
        }

        accept.shutdownOutput();
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }


  //首先来分析一下 前端传递过来的是不是一个请求(前后端交互的请求[前端带数据到后端]),如果不带数据只是作为一个前端静态页面加载算不上一个前后端交互的请求
  private static Request parse(InputStream inputStream) throws IOException { //Url
    String url = null;
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
     Request request = new Request();

     Integer  length=0;
    String  jsonData="";

    String line = bufferedReader.readLine();
    url = line.split(" ")[1];  //到此为止就能得到url

    while (line != null && line.length() != 0) {
      System.out.println(line);
      if (line.startsWith("Content-Length:")) {
        length=Integer.valueOf(line.replace("Content-Length: ", ""));
      }
      line = bufferedReader.readLine();
    }
    //如果length>0就说明前端有数据传递过来
    if(length>0){   //如果想要获取header后面的数据 就要再一次读取
      char[] chars=new char[length];
     int key= bufferedReader.read(chars); //可以使用这种方式  确定长度
      jsonData = new String(chars,0,key);//json数据
    }
    request.setUrl(url);
    request.setData(jsonData);

    return  request;
  }
}
