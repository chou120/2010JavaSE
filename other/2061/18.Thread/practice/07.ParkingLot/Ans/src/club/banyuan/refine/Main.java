package club.banyuan.refine;

public class Main {

  public static void main(String[] args) {
    ParkingLot parkingLot = new ParkingLot();
    CarGenerator carGenerator = new CarGenerator(parkingLot);
    carGenerator.start();
    parkingLot.start();
  }
}
