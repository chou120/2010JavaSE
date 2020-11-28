package club.service.dao;

import club.service.entity.Product;
import club.service.util.ArrayList;

/**
 * @author sanye
 * @version 1.0
 * @date 2020/11/26 7:06 下午
 */
public interface ProductDao {

  ArrayList showAllProduct();

  /**
   * 添加功能
   * @param product
   */
  void   add(Product product);

  /**
   * 查询功能
   * @param proId
   * @return
   */
  Product getById(String proId);

  /**
   * 更新功能
   * @param product
   */
  void  updateProduct(Product product);


  /**
   * 删除功能
   * @param proId
   * @return
   */
  boolean  deleteById(String  proId);



}
