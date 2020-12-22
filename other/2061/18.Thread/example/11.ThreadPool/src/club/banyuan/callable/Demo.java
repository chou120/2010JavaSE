package club.banyuan.callable;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

public class Demo {

  public static void main(String[] args) {

    FutureTask<String> task = new FutureTask<>(new Callable<String>() {
      @Override
      public String call() throws Exception {
        System.out.println("线程启动！");
        Thread.sleep(2000);
        throw new Exception("异常");
        // return "线程结束";
      }
    });
    Thread thread = new Thread(task);
    thread.start();
    String s = null;
    try {
      s = task.get();
    } catch (InterruptedException e) {
      // e.printStackTrace();
    } catch (ExecutionException e) {
      System.out.println(e.getCause().getMessage());
      // e.printStackTrace();
    }
    // System.out.println(s);

    ExecutorService executorService = Executors.newFixedThreadPool(1);
    Future<String> submit = executorService.submit(new Callable<String>() {
      @Override
      public String call() throws Exception {
        return null;
      }
    });

  }

}
