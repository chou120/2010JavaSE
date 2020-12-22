package club.banyuan.refine;

public class CarPort {

  private Car car;
  private long carInTime;

  public boolean isEmpty() {
    return car == null;
  }

  public void in(Car car) {
    // 车入库的时候记录入库的时间
    carInTime = System.currentTimeMillis();
    this.car = car;
  }

  /**
   * 移除车位上的车，不需要传入汽车的对象
   */
  public void out() {
    this.car = null;
    carInTime = 0;
  }

  public boolean isCarIn(Car car) {
    return this.car == car;
  }

  public long getCarInTime() {
    return carInTime;
  }

  public Car getCar() {
    return car;
  }

  @Override
  public String toString() {
    return car == null ? "空" : car.toString() + "\t停车时长" + countParkTime() + "秒";
  }

  private long countParkTime() {
    return (System.currentTimeMillis() - carInTime) / 1000;
  }
}
