package club.banyuan.annotation;

/**
 * @author sanye
 * @version 1.0
 * @date 2020/12/16 4:07 下午
 */

public class Person {

  @MyAnnotation("沾上干")
  private  String name;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @MyAnnotation
  public  void    show(){

  }


}
