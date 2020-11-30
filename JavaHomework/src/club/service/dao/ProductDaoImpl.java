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
      DataSource.PRODUCT_ARRAY_LIST.add(product);
  }

  @Override
  public Product getById(String proId) {
    //TODO
    ArrayList productArrayList = DataSource.PRODUCT_ARRAY_LIST;
    for (int i = 0; i <productArrayList.size(); i++) {
      Product  pro=(Product) productArrayList.get(i);
      if(pro.getNumber().equals(proId)){
        return    pro;
      }
    }
    return null;
  }

  @Override
  public void updateProduct(Product product) {
    //TODO
  }

  @Override
  public boolean deleteById(String proId) {
    //TODO
          //传递过去的是一个字符串编号
    return DataSource.PRODUCT_ARRAY_LIST.remove(proId);
  }
}
