package club.banyuan.refine;

import java.util.Random;

public class Car extends Thread {

  private String plate;
  private final ParkingLot parkingLot;

  public Car(String plate, ParkingLot parkingLot) {
    this.plate = plate;
    this.parkingLot = parkingLot;
    System.out.println("生产汽车：" + plate);
  }

  public String getPlate() {
    return plate;
  }

  public void setPlate(String plate) {
    this.plate = plate;
  }


  @Override
  public void run() {

    try {
      synchronized (parkingLot) {
        // 等待直到被通知车位有空闲
        while (!parkingLot.hasEmptyPort()) {
          System.out.println(plate + "等待空车位");
          parkingLot.wait();
        }

        parkingLot.carIn(this);
      }

      // 模拟入库之后停车的耗时
      Thread.sleep(new Random().nextInt(10000));

      parkingLot.carOut(this);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  @Override
  public String toString() {
    return "车牌：" + plate;
  }
}
