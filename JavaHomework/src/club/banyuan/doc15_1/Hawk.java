package club.banyuan.doc15_1;

/**
 * @author sanye
 * @version 1.0
 * @date 2020/11/25 1:42 下午
 */
public class Hawk  extends  Bird {

  private  double height;

  public Hawk() {
  }

  public Hawk(double height) {
    this.height = height;
  }

  public Hawk(String wings, String legs, double height) {
    super(wings, legs);
    this.height = height;
  }

  public double getHeight() {
    return height;
  }

  public void setHeight(double height) {
    this.height = height;
  }

  public  void   catchFood(){
    System.out.println("老鹰抓捕食物");
  }

}
