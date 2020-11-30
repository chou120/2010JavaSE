package club.banyuan;

import java.io.IOException;
import java.text.ParseException;

/**
 * @author sanye
 * @version 1.0
 * @date 2020/11/30 4:16 下午
 */
public interface MyException {

  //看父类异常类型  都是属于运行时异常  同类异常都行
  void  login() throws  NullPointerException;
  void  register() throws  IllegalArgumentException;
  void  update() throws   IndexOutOfBoundsException;

  void   delete() throws ParseException;


  //throws关键字的使用限制的，即子类声明的抛出异常不允许比父类抛出的异常多，当父类抛出的异常不是Exception的时候，子类是不允许抛出Exception的

}


class  MyExceptionImpl  implements  MyException{

  @Override
  public void login() throws NullPointerException{  //如果子类方法要抛出多个异常,那么最好抛出同类的异常

  }

  @Override
  public void register() throws IllegalArgumentException {

  }

  @Override
  public void update() throws IndexOutOfBoundsException {

  }
  @Override
  public void delete() throws ParseException {

  }
}