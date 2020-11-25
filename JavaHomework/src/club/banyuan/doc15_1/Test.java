package club.banyuan.doc15_1;

/**
 * @author sanye
 * @version 1.0
 * @date 2020/11/25 1:46 下午
 */
public class Test {


  public static void main(String[] args) {
    Bird  bird=new Sparrow();
    bird=new Sparrow("苏奥迪", "安达顺");

    bird=new Hawk();

//    Bird  hawk=(Hawk)new Bird();
//    hawk.catchFood();

//    new Hawk().catchFood();
//
//Bird hawk = (Hawk)(new  Hawk());   //
      Bird  bird1=new Hawk();  //把子类类型提升了
      //如果是子类特有的方法 那就没发生方法重写
      //调用子类特有的方法:第一步:强转        目标类型   对象名=(目标类型)父类引用名;
       Hawk h=(Hawk)bird1;
       //第二步
       h.catchFood();





  }
}
