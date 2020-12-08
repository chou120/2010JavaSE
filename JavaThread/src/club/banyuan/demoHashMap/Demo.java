package club.banyuan.demoHashMap;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author sanye
 * @version 1.0
 * @date 2020/12/8 10:20 上午
 */
public class Demo {


  public  static HashMap<String,String> map=new HashMap<>();
  //public  static ConcurrentHashMap<String,String> map=new ConcurrentHashMap<>();

  public static void main(String[] args) {

    Thread thread=new Thread(){
      @Override
      public void run() {
        for (int i = 0; i <5000; i++) {
          map.put(String.valueOf(i),String.valueOf(i));
        }
      }
    };
    Thread thread2=new Thread() {
      @Override
      public void run() {
        for (int i = 5000; i <10000; i++) {
          map.put(String.valueOf(i),String.valueOf(i));
        }
      }
    };
    thread.start();
    thread2.start();

    try {
      Thread.sleep(1000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    for(int l =0;l <100;l++){
      //如果key和value不同，说明两个线程在put的过程出现异常
      if(!String.valueOf(l).equals(map.get(String.valueOf(l)))){
        System.out.println(String.valueOf(l)+": "+map.get(String.valueOf(l)));
      }
    }
  }
}
