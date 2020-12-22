package club.banyuan;

public class ParkingLot extends Thread {

  private Car[] carports = new Car[MAX];
  private int count;
  private static final int MAX = 10;

  public synchronized void carIn(Car car) {
    if (count == MAX) {
      throw new IllegalStateException("车位满了");
    }
    for (int i = 0; i < carports.length; i++) {
      if (carports[i] == null) {
        System.out.println(car.getPlate() + "入库:" + i);
        carports[i] = car;
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
      if (car.equals(carports[i])) {
        System.out.println(car.getPlate() + "出库:" + i);
        carports[i] = null;
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
    for (Car car : carports) {
      if (car != null && car.getPlate().equals(plate)) {
        return car;
      }
    }

    return null;
  }

  public boolean isEmpty(int index) {
    if (index < 0 || index >= MAX) {
      throw new IndexOutOfBoundsException("编号不合法:" + index);
    }

    return carports[index] == null;
  }

  public synchronized boolean hasEmptyPort() {
    return count < MAX;
  }

  // 打印每个车位的停车信息的方法
  public synchronized void printCars() {
    for (int i = 0; i < carports.length; i++) {
      Car car = carports[i];
      String carMsg = car == null ? "空" : car.toString();
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
