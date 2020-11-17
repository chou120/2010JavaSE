package club.banyuan.oop;

/**
 * @author sanye
 * @version 1.0
 * @date 2020/11/16 3:46 下午
 */
public class Hammer {

  /*
      锤子有什么属性：
        材质    "钛合金"
        形状    长条
        质量    1.2kg
        长度    30.8cm
        价格    1.35
        名字    壁咚锤
        ...

      锤子的行为:
        qiao();
   */
  private String material = "钛合金";  //
  private String form = "长条";
  private double weigth = 1.2; //kg
  private double length = 30.8; //厘米
  private  double price = 1.35; // 价格  将模板的属性隐藏  防止别的工具直接调用修改数据  可能会导致数据安全问题
  private String name = "壁咚锤";  //全局变量


  public void setMaterial(String newMaterial) {
    if(newMaterial.length()>0 && newMaterial.length()<20){
      material = newMaterial;
    }else{
      System.err.println("长度超出");
    }
  }
  public void setForm(String newForm) {
    if(newForm.length()>0 && newForm.length()<20){
      form = newForm;
    }else{
      System.err.println("长度超出");
    }
  }

  public void setName(String newName) {
    if(newName.length()>0 && newName.length()<20){
      name = newName;
    }else{
      System.err.println("长度超出");
    }
  }

  public   void  setPrice(double  newPrice){
    if(newPrice<0 || newPrice > 1000000){
      System.err.println("价格异常");
    }else{
      price=newPrice; //rmb
    }
  }

  public  void setWeigth(double  newWeight){
    if(newWeight<0 || newWeight > 200){
      System.err.println("质量异常");
    }else{
      weigth=newWeight;  //kg
    }
  }

  public  void setLength(double newLength){
    if(newLength<0 || newLength > 100){
      System.err.println("长度异常");
    }else{
      length=newLength;//cm
    }

  }


  public void qiaoren() {
    String   address="";
    System.out.println("张三使用" + name + "对jax壁咚");
  }

  //锤子显示自身各项属性的行为
  public String getInfo() {
    return "重新创建的锤子对象各项属性为:" +
        "name:" + name + ",form:" + form
        + ",length:" + length + ",material:" + material
        + ",price:" + price + ",weigth:" + weigth;
  }


}

//来一个测试类
class Test {

  public static void main(String[] args) {

    //System.out.println(3/0);  //一般对数据处理      考虑分母  不能为0   by  zero    java.lang.ArithmeticException: / by zero


    /**
     * 创建对象的格式:
     *  类名  变量名(对象名)=new  类名();
     *  对象名.成员(属性和方法)
     */
    //实例化Hammer对象
//    Hammer hammer = new Hammer();
//    hammer.qiaoren();
//
//    String info = hammer.getInfo();
//
//    System.out.println("输出的信息为:" + info);
//
//    Hammer hammer2 = new Hammer();
//    System.out.println("锤子2的名字叫:" + hammer2.name);
//
//    Hammer hammer3 = new Hammer();
//    System.out.println("锤子3的名字叫:" + hammer3.name);
//
//    Hammer hammer4 = new Hammer();
//    // System.out.println("锤子4的名字叫:"+hammer4.name);
//    System.out.println(">>>>>>>>>>>>>>>>>>>>");
    // showInformation(hammer4);
    /**
     * 请问创建上面的三个锤子对象 有什么共同的地方
     */

    //从现在开始  生产出来的锤子的属性值都要发生变化
    Hammer newHammer = new Hammer();
//    newHammer.name = "铁榔头";
//    newHammer.form = "圆形";
//    newHammer.length = 400;
//    newHammer.material = "陨石";
//    //newHammer.price = 0.5;
//    newHammer.weigth = 2.5;
//
//    System.out.println(newHammer.hashCode());  //747464370
//
//    Hammer hammer=newHammer;  //
//    hammer.name="张三";

    //System.out.println(hammer.hashCode());  //747464370

    System.out.println(newHammer.getInfo());
//     String s = showInformation(newHammer);
//
////    System.out.println("重新创建的锤子对象各项属性为:"+
////        "name:"+newHammer.name+",form:"+newHammer.form
////    +",length:"+newHammer.length+",material:"+newHammer.material
////    +",price:"+newHammer.price+",weigth:"+newHammer.weigth);
//
//    Hammer newHammer2 = new Hammer();
//    newHammer2.name="石头";
//    newHammer2.material="木头";
//
//    s = showInformation(newHammer2);
//    System.out.println(s);
//
////    System.out.println("重新创建的锤子对象各项属性为:"+
////        "name:"+newHammer2.name+",form:"+newHammer2.form
////        +",length:"+newHammer2.length+",material:"+newHammer2.material
////        +",price:"+newHammer2.price+",weigth:"+newHammer2.weigth);
//
//    Hammer newHammer3 = new Hammer();
//    newHammer3.name="你爸";
//    newHammer3.material="泥巴";
//
//    s = showInformation(newHammer3);
//    System.out.println(s);

//    System.out.println("重新创建的锤子对象各项属性为:"+
//        "name:"+newHammer3.name+",form:"+newHammer3.form
//        +",length:"+newHammer3.length+",material:"+newHammer3.material
//        +",price:"+newHammer3.price+",weigth:"+newHammer3.weigth);
  }

  /**
   * Hammer 是数据类型
   *
   * @param hammer  变量名  用来接受hammer对象
   * @return
   */

  //请问 这个方法输出的是不是创建的对象的所有的信息
//  public  static  String  showInformation(Hammer  hammer){  //用来接受的是锤子对象
//    return  "重新创建的锤子对象各项属性为:"+
//        "name:"+hammer.name+",form:"+hammer.form
//        +",length:"+hammer.length+",material:"+hammer.material
//        +",price:"+hammer.price+",weigth:"+hammer.weigth;
//  }
//
//

}
