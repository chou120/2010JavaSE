package club.banyuan.oopHomework0802.dog;

import club.banyuan.oopHomework0802.cat.Cat;

/**
 * @author sanye
 * @version 1.0
 * @date 2020/11/18 9:36 上午
 */
public class Dog {
  private String  type;
  private int  IQ;

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public int getIQ() {
    return IQ;
  }

  public void setIQ(int IQ) {
    this.IQ = IQ;
  }

  public  String  getInfo(){
    //（<20为傻， 20~80为普通的，>80为聪明的）
    if(IQ<20){
      return "傻狗"+type;
    }  else if(IQ>=20 && IQ<=80){
      return "普通狗子"+type;
    }else{
      return  "聪明"+type;
    }
  }

  //打印方法
//  public  String   printInfo(){
//    String info = getInfo();
//    return  info;
//  }

  public  void   printInfo(){
    System.out.println(getInfo());
  }
  public  void playWith(Cat cat){
    System.out.println(this.type+"与"+cat.getType()+"一起玩耍");
  }


}
