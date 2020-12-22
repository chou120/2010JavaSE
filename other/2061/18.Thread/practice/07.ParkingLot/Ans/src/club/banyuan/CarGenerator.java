package club.banyuan;

public class CarGenerator extends Thread {

  private static int plate = 10000;
  private final ParkingLot parkingLot;

  public CarGenerator(ParkingLot parkingLot) {
    this.parkingLot = parkingLot;
  }

  @Override
  public void run() {
    while (true) {
      synchronized (parkingLot) {
        while (!parkingLot.hasEmptyPort()) {
          try {
            System.out.println("停止生产");
            parkingLot.wait();
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
        }
      }

      generateCar();
      generateCar();
      try {
        Thread.sleep(500);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }

  private void generateCar() {
    new Car(plate + "", parkingLot).start();
    plate++;
  }
}
