package club.banyuan.demoProduct.run;

import club.banyuan.demoProduct.Product;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author sanye
 * @version 1.0
 * @date 2020/12/7 10:25 上午
 */
public class Test {

  public static void main(String[] args) {
    Product product = new Product();
    MyThread myThread = new MyThread(product);

    Thread threadA = new Thread(myThread, "张三");
    Thread threadB = new Thread(myThread, "李四");
    threadA.start();
    threadB.start();

    //HashTable  CurrentHashMap


  }
}
