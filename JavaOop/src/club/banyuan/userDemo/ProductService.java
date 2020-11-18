package club.banyuan.userDemo;

/**
 * @author sanye
 * @version 1.0
 * @date 2020/11/18 11:21 上午
 */
public class ProductService {

  private Product[] products = new Product[10];
  private  String[] address={"江苏南京","江苏苏州","江苏南通","江苏常州","广东佛山","黑龙江哈尔滨"};

  {  //给数组添加商品对象
    for (int i = 0; i < products.length; i++) {
      Product product = new Product();
      product.setProductId("9527"+i);
      product.setPrice((int)(Math.random()*50)+50);
      product.setProName("产品"+(i+1)+"号");
      product.setSize(""+(i+1));
      int  index=(int)(Math.random()*address.length);// [0,10)   0~9.999999999
      product.setProAddress(address[index]);
      products[i]=product;

    }
  }

  //商品详情列表
  public   void  showAll() {
    for (int i = 0; i <products.length; i++) {
      System.out.println(products[i]);
    }

  }

}
