package club.banyuan.doc15_2;

/**
 * @author sanye
 * @version 1.0
 * @date 2020/11/25 1:59 下午
 */
public class People  extends  Monkey{

  public People(String s) {
    super(s);
  }

  @Override
  public void speak() {
    System.out.println("小样的，不错嘛！会说话了！");
  }

  public  void think(){
    System.out.println("别说话！认真思考！");
  }

}
