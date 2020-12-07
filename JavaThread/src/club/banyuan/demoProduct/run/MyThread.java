package club.banyuan.demoProduct.run;

import club.banyuan.demoProduct.Product;

/**
 * @author sanye
 * @version 1.0
 * @date 2020/12/7 10:22 上午
 */
public class MyThread  implements  Runnable{

  private static Product  product;

  public MyThread(Product product) {
    this.product = product;
  }

  @Override
  public void run() {
      while(true){
        show();
        try {
          Thread.sleep(1000);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
  }

//  synchronized public void show() {  //同步方法的对象锁是当前对象
//
//      if (product.getNumber() < 1) {
//        return;
//      }
//      final int number = product.getNumber(); //获取商品的数量
//      product.setNumber(number - 1); //一个顾客 线程抢占完了之后商品数量会减少一个
//      System.out.println(Thread.currentThread().getName() + "抢到了第" + number + "件商品");
//
//  }


  synchronized static public void show() {  //静态同步方法的 对象锁是当前类的class文件  MyThread.class

    if (product.getNumber() < 1) {
      return;
    }
    final int number = product.getNumber(); //获取商品的数量
    product.setNumber(number - 1); //一个顾客 线程抢占完了之后商品数量会减少一个
    System.out.println(Thread.currentThread().getName() + "抢到了第" + number + "件商品");

  }
}
