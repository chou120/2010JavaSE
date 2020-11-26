package club.banyuan.bird;

public class Main {

  public static void show(Bird bird) {
    System.out.println(bird.getName() + "能够飞 " + bird.fly() + "米");
  }

  public static void main(String[] args) {

//    show(new Bird() {
//      @Override
//      public String getName() {
//        return "燕子";
//      }
//      @Override
//      public int fly() {
//
//        return 1000;
//      }
//    });
     Bird bird = new Bird() {
      @Override
      public int fly() {
        return 1000;
      }
    };
    bird.setName("燕子");
    show(bird);
  }
}