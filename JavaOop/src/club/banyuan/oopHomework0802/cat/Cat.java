package club.banyuan.oopHomework0802.cat;

import club.banyuan.oopHomework0802.dog.Dog;

/**
 * @author sanye
 * @version 1.0
 * @date 2020/11/18 9:36 上午
 */
public class Cat {
  private  String type;
  private  String color;

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public String getColor() {
    return color;
  }

  public void setColor(String color) {
    this.color = color;
  }

  public  String  getInfo(){
      return this.color+this.type;
  }
  public  void   printInfo(){
    System.out.println(getInfo());
  }

  public  void playWith(Dog dog){
    System.out.println(this.getInfo()+"与"+dog.getInfo()+"一起玩耍");
  }



}
