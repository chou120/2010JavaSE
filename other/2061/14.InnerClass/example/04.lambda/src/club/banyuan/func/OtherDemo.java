package club.banyuan.func;

public class OtherDemo {

  public A test(EffectivelyFinalDemo demo) {
    int i = 10;
    A a = new A() {
      @Override
      public void methodA() {
        System.out.println(demo.fieldI);
        System.out.println(i);
        demo.fieldI++;
      }
    };
    return a;

  }
}
