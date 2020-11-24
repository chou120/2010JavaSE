package club.banyuan.anonymityInner;

import java.util.Comparator;

/**
 * @author sanye
 * @version 1.0
 * @date 2020/11/24 3:37 下午
 */
public class InnerImpl implements Inner {
  @Override
  public int compera(int x, int y) {
    if (x > y) {
      return x;
    }
    return y;
  }
}

class Test {

  public static void main(String[] args) {
//    Inner inner = new InnerImpl();
//    int compera = inner.compera(123, 4);
//    System.out.println(compera);

//     Inner  inner = new Inner() {  //创建的是匿名的子类对象
//      @Override
//      public int compera(int x, int y) {
//        if (x > y) {
//          return x;
//        }
//        return y;
//      }
//    };
//     int compera = inner.compera(123, 4);
//    System.out.println(compera);
//







  }
}
