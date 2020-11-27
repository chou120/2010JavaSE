package club.service.util;

import club.service.entity.Product;
import club.service.entity.User;

/**
 * @author sanye
 * @version 1.0
 * @date 2020/11/26 6:25 下午
 */
public class DataSource {

  public static final ArrayList PRODUCT_ARRAY_LIST = new ArrayList();
  public static final ArrayList USER_ARRAY_LIST = new ArrayList();
  private static String[] proNames = {"元宵", "T恤", "孕妇装", "型男装", "内衣"};
  private static String[] proAddress = {"苏州", "南京", "泰州", "昆山", "上海"};

  static {
    for (int i = 0; i < 5; i++) {
      USER_ARRAY_LIST.add(new User("张三" + i, "123456" + i, "1398989889" + i));
    }

    for (int i = 0; i < 10; i++) {
      Product product = new Product();
      String proName = proNames[(int) (Math.random() * proNames.length)];
      product.setProductName(proName + i+"号");
      String proAddress1 = proAddress[(int) (Math.random() * proAddress.length)];
      product.setAddress(proAddress1);
      PRODUCT_ARRAY_LIST.add(product);
    }

  }
}
