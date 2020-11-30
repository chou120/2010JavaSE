package club.banyuan.demo4;

import club.banyuan.demo4.Food.Coffee;
import club.banyuan.demo4.Food.MainCourse;

/**
 * @author sanye
 * @version 1.0
 * @date 2020/11/30 1:44 下午
 */
public interface Food {

  enum Appetizer implements Food {
    SALAD, SOUP, SPRING_ROLLS;
  }

  enum MainCourse implements Food {
    LASAGNE("热狗肠"), BURRITO("玉米煎饼"), PAD_THAI("炒河粉"),
    LENTILS("炒面"), HUMMOUS("腊肉"), VINDALOO("咖喱肉");

    private  String  name;

    MainCourse(String name) {
      this.name = name;
    }

    public String getName() {
      return name;
    }
  }

  enum Dessert implements Food {
    TIRAMISU, GELATO, BLACK_FOREST_CAKE,
    FRUIT, CREME_CARAMEL;
  }

  enum Coffee implements Food {
    BLACK_COFFEE, DECAF_COFFEE, ESPRESSO,
    LATTE, CAPPUCCINO, TEA, HERB_TEA;
  }

}

class TestFood {

  public static void main(String[] args) {
    Food.MainCourse burrito = MainCourse.BURRITO;

    System.out.println(burrito.name()+burrito.getName());

  }

}
