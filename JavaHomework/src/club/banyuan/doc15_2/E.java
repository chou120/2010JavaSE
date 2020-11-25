package club.banyuan.doc15_2;

/**
 * @author sanye
 * @version 1.0
 * @date 2020/11/25 1:59 下午
 */
public class E {

  public static void main(String[] args) {
    Monkey  monkey=new Monkey("一品猴子");
    monkey.speak();

    monkey=new People("顶级人类");
    monkey.speak();

    People  people=(People)monkey;
    people.think();

    ((People)monkey).think();

  }
}
