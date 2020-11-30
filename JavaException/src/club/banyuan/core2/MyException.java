package club.banyuan.core2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * @author sanye
 * @version 1.0
 * @date 2020/11/30 2:46 下午
 */
public class MyException {

  /*try{
    //try块中放可能发生异常的代码。     //如果执行完try且不发生异常，则接着去执行finally块和finally后面的代码（如果有的话）。
    //如果发生异常，则尝试去匹配catch块。

  }catch(SQLException SQLexception){
    //每一个catch块用于捕获并处理一个特定的异常，或者这异常类型的子类。Java7中可以将多个异常声明在一个catch中。
    //catch后面的括号定义了异常类型和异常参数。如果异常与之匹配且是最先匹配到的，则虚拟机将使用这个catch块来处理异常。
    //在catch块中可以使用这个块的异常参数来获取异常的相关信息。异常参数是这个catch块中的局部变量，其它块不能访问。
    //如果当前try块中发生的异常在后续的所有catch中都没捕获到，则先去执行finally，然后到这个函数的外部caller中去匹配异常处理器。
      //如果try中没有发生异常，则所有的catch块将被忽略。
  }catch(Exception exception){
    //...
  }finally{
    //finally块通常是可选的。   //无论异常是否发生，异常是否匹配被处理，finally都会执行。
    //一个try至少要有一个catch块，否则， 至少要有1个finally块。但是finally不是用来处理异常的，finally不会捕获异常。
    //finally主要做一些清理工作，如流的关闭，数据库连接的关闭等。  资源的释放


  }*/


  public static void main(String[] args) {

    Scanner  scanner=new Scanner(System.in);

    try{

      System.out.println("请输入第一个数：");
      int   num1=scanner.nextInt();
      System.out.println("请输入第二个数：");
      int   num2=scanner.nextInt();
      System.out.println(num1/num2);  //可能出现异常的代码块的位置

    }catch (ArithmeticException  | InputMismatchException e){
      //System.out.println("出现的异常信息为:"+e.getMessage());
        e.printStackTrace();//打印异常的堆栈信息
      /**
       * java.lang.ArithmeticException: / by zero  出现异常错误的类型
       * 	at club.banyuan.core2.MyException.main(MyException.java:40)  出现错误的位置
       */
    } finally {
      System.out.println("finally代码块...");
      //scanner.close();
    }

    System.out.println("最后的代码块有没有执行...");


//    try{
//
//    }catch (){
//
//    }
//    try{
//
//    }finally {
//
//    }
//
//    try{
//
//    }catch (异常类型1  |  异常类型2 |  ... e){
//
//    }final {
//
//    }
//

//    try(FileOutputStream  f=new FileOutputStream( new File(""));){
//      //表示资源自动关闭,前提是有可关闭的资源  比如  数据库   文件流关闭等等
//
//
//    } catch (FileNotFoundException e) {
//      e.printStackTrace();
//    } catch (IOException e) {
//      e.printStackTrace();
//    }


//    try {
//
//    }catch (ArrayIndexOutOfBoundsException e){  //子类
//
//    }catch (RuntimeException e){ //子类
//
//    }catch (Exception  e){ //父类
//
//    }











  }

}
