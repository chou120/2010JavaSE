package club.service.dao;

import club.service.entity.Product;
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

  @Override
  public void add(Product product) {
    //TODO
  }

  @Override
  public Product getById(String proId) {
    //TODO
    return null;
  }

  @Override
  public void updateProduct(Product product) {
    //TODO
  }

  @Override
  public boolean deleteById(String proId) {
    //TODO
    return false;
  }
}
