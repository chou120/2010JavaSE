package club.banyuan.com;

/**
 * @author sanye
 * @version 1.0
 * @date 2020/11/23 2:04 下午
 */
public class Tool {

  private  Tool(){

  }
//  public   static   void   getDog(Dog  dog){
//    dog.eat();
//  }
//
//  public   static   void   getCat(Cat cat){
//    cat.eat();
//  }
//  public   static   void   getPig(Pig  pig){
//    pig.eat();
//  }
  //相比来说  这种写法是不是减少了很多代码
  public   static   void   getAnimal(Animal  animal){  //请问在此方法出 你能看出来接受的是什么具体对象
    animal.eat();
  }

}
