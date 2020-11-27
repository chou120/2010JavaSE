package club.service.dao;

import club.service.util.ArrayList;
import club.service.util.DataSource;

/**
 * @author sanye
 * @version 1.0
 * @date 2020/11/26 7:33 下午
 */
public class ProductDaoImpl implements  ProductDao {

  @Override
  public ArrayList showAllProduct() {
    return DataSource.PRODUCT_ARRAY_LIST;
  }
}
