package club.banyuan.demo3;

/**
 * @author sanye
 * @version 1.0
 * @date 2020/11/30 1:34 下午
 */
public enum Season {

  FIRST {
    @Override
    public String getInfo() {
      System.out.println("first");
      return null;
    }
  },
  SECOND {
    @Override
    public String getInfo() {
      return null;
    }
  };

  public abstract String getInfo();


}

class Test {

  public static void main(String[] args) {
    Season.FIRST.getInfo();


  }

}


interface food {

  void eat();
}

interface sport {

  void run();
}

enum EnumDemo2 implements food, sport {
  FOOD,
  SPORT,
  ; //分号分隔

  @Override
  public void eat() {
    System.out.println("eat.....");
  }

  @Override
  public void run() {
    System.out.println("run.....");
  }
}



