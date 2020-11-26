package club.banyuan.doc15_3_3;

/**
 * @author sanye
 * @version 1.0
 * @date 2020/11/26 9:21 上午
 */
public  abstract class Person {
  private  String name;

  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  public    void   goHome(){
    System.out.println("回家方法一样");
  }
  public    void  buyTicket(){
    System.out.println("买票的方式一样");
  }
  public  abstract  void goHomeTool();

  /**
   * 一个方法被很多子类进行重写  这个需要使用抽象类
   *
   * 接口是在添加额外的需求的时候使用   implements  A
   */



}
