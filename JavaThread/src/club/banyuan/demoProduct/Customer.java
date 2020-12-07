package club.banyuan.demoProduct;

/**
 * @author sanye
 * @version 1.0
 * @date 2020/12/7 9:32 上午
 */
public class Customer extends  Thread{

  private Product product;//保证商品的唯一性

  public Customer(String name, Product product) {
    super(name);
    this.product = product;
  }

  @Override
  public void run() {

    while(true){
      synchronized (Customer.class){

        if(product.getNumber()<1){
          break;
        }

        final int number = product.getNumber(); //获取商品的数量
        product.setNumber(number-1); //一个顾客 线程抢占完了之后商品数量会减少一个
        System.out.println(Thread.currentThread().getName()+"抢到了第"+number+"件商品");

//        try {
//          Thread.sleep(1000);
//        } catch (InterruptedException e) {
//          e.printStackTrace();
//        }
      }
      //到此  休眠之后的线程也会加入抢占
      try {
          Thread.sleep(1000);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
    }
  }
}
class Test{

  public static void main(String[] args) {
    final Product product = new Product();
    Customer  customer1=new Customer("张三",product);
    Customer  customer2=new Customer("李四",product);
    customer1.start();
    customer2.start();



  }
}