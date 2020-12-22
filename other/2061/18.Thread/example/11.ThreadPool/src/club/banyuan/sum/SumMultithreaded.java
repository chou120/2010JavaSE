package club.banyuan.sum;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 线程计算数组元素的正弦值的和。
 */
class SumThread implements Callable<Double> {


  private int lo, hi;
  private int[] arr;
  private double ans = 0;

  public SumThread(int[] arr, int lo, int hi) {
    this.lo = lo;
    this.hi = hi;
    this.arr = arr;
  }

  // @Override
  // public void run() {
  //   for (int i = lo; i < hi; i++) {
  //     ans += Math.sin(arr[i]);
  //   }
  // }


  public double getAns() {
    return ans;
  }

  @Override
  public Double call() throws Exception {
    for (int i = lo; i < hi; i++) {
      ans += Math.sin(arr[i]);
    }
    return ans;
  }
}

public class SumMultithreaded {

  /**
   * 对数组中所有元素的正弦值求和。
   * 将数组拆分成多组，分别使用多个线程分别计算得出结果后再加到一起
   *
   * @param arr 求和数组
   * @return 数组元素的和
   * @throws InterruptedException 应该不会出现此异常
   */
  public static double sum(int[] arr, int numThreads)
      throws InterruptedException, ExecutionException {
    ExecutorService executorService = Executors.newFixedThreadPool(numThreads);

    int len = arr.length;
    double ans = 0;

    // 创建并启动线程。
    List<Future<Double>> futures = new ArrayList<>();

    for (int i = 0; i < numThreads; i++) {
      SumThread task = new SumThread(arr, (i * len) / numThreads, ((i + 1) * len / numThreads));
      futures.add(executorService.submit(task));
    }

    // 等待线程完成并计算它们的结果。
    for (Future<Double> future : futures) {
      ans += future.get();
    }

    return ans;
  }

}
