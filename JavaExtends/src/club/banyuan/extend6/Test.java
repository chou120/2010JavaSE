package club.banyuan.extend6;

/**
 * @author sanye
 * @version 1.0
 * @date 2020/11/20 11:06 上午
 */
public class Test {
  public static void main(String[] args) {
    Son son = new Son();
    System.out.println(son.name);
    System.out.println(son.address);//当子类没有跟父类属性名相同的属性时,使用的 是父类的
    ////当子类里面有自己的属性时优先使用子类自己的,如果没有再去找父类
    System.out.println(son.hairColor);

    son.methodInf();


  }

}
