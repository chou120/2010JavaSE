package club.banyuan;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

class MaxThread implements Callable<Double> {

  private int lo, hi;
  private int[] arr;
  private double ans = 0;

  public MaxThread(int[] arr, int lo, int hi) {
    this.lo = lo;
    this.hi = hi;
    this.arr = arr;
  }

  // @Override
  // public void run() {
  //   ans = Math.sin(arr[lo]);
  //   for (int i = lo; i < hi; i++) {
  //     double sin = Math.sin(arr[i]);
  //     if (ans < sin) {
  //       ans = sin;
  //     }
  //   }
  // }

  public double getAns() {
    return ans;
  }

  @Override
  public Double call() throws Exception {

    ans = Math.sin(arr[lo]);
    for (int i = lo; i < hi; i++) {
      double sin = Math.sin(arr[i]);
      if (ans < sin) {
        ans = sin;
      }
    }
    return ans;
  }
}

public class MaxMultithreaded {

  /**
   * 计算数组元素的sin值之后，返回最大值。
   *
   * @param arr 目标数组
   * @return sin(数组元素)的最大值
   * @throws InterruptedException 不应该出现此异常
   */
  public static double max(int[] arr, int numThreads) throws InterruptedException {
    int len = arr.length;
    ExecutorService executorService = Executors.newFixedThreadPool(numThreads);

    List<Future<Double>> futureList = new ArrayList<>();
    // 创建并启动线程。
    for (int i = 0; i < numThreads; i++) {
      MaxThread task = new MaxThread(arr, (i * len) / numThreads, ((i + 1) * len / numThreads));
      Future<Double> submit = executorService.submit(task);
      futureList.add(submit);
    }

    double rlt = Double.NEGATIVE_INFINITY;
    // 等待线程完成并计算它们的结果。
    for (int i = 0; i < numThreads; i++) {
      Double aDouble = null;
      try {
        aDouble = futureList.get(i).get();
      } catch (ExecutionException e) {
        e.printStackTrace();
      }
      if (rlt < aDouble) {
        rlt = aDouble;
      }
    }
    return rlt;
  }
}
