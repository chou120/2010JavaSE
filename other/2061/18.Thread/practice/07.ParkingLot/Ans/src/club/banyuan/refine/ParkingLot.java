package club.banyuan.refine;

public class ParkingLot extends Thread {

  private CarPort[] carports;
  private int count;
  private static final int MAX = 10;

  {
    carports = new CarPort[MAX];
    for (int i = 0; i < carports.length; i++) {
      carports[i] = new CarPort();
    }
  }

  public synchronized void carIn(Car car) {
    if (count == MAX) {
      throw new IllegalStateException("车位满了");
    }
    for (int i = 0; i < carports.length; i++) {
      if (carports[i].isEmpty()) {
        System.out.println(car.getPlate() + "入库:" + i);
        carports[i].in(car);
        count++;
        break;
      }
    }
  }

  /**
   * 在出库的时候通知其他车辆
   *
   * @param car
   */
  public synchronized void carOut(Car car) {
    for (int i = 0; i < carports.length; i++) {
      if (carports[i].isCarIn(car)) {
        System.out.println(car.getPlate() + "出库:" + i);
        carports[i].out();
        count--;
        // 通知其他的等待的汽车可以尝试入库
        notifyAll();
        break;
      }
    }
  }


  // 查询当前停车场的剩余车位方法
  public int portLeft() {
    return MAX - count;
  }

  // 根据车牌号查询汽车对象的方法
  public Car getCar(String plate) {
    for (CarPort carPort : carports) {
      if (!carPort.isEmpty() && carPort.getCar().getPlate().equals(plate)) {
        return carPort.getCar();
      }
    }

    return null;
  }

  public boolean isEmpty(int index) {
    if (index < 0 || index >= MAX) {
      throw new IndexOutOfBoundsException("编号不合法:" + index);
    }

    return carports[index].isEmpty();
  }

  public synchronized boolean hasEmptyPort() {
    return count < MAX;
  }

  // 打印每个车位的停车信息的方法
  public synchronized void printCars() {
    for (int i = 0; i < carports.length; i++) {
      CarPort carPort = carports[i];
      String carMsg = carPort.toString();
      System.out.println("车位" + (i + 1) + ":" + carMsg);
    }
  }


  @Override
  public void run() {
    while (true) {
      try {
        Thread.sleep(1000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      printCars();
    }

  }
}
