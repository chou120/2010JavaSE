package club.banyuan;

public class Car extends Vehicle {

  int seats;

  public Car(String vendor, int year, int seats) {
    super(vendor, year);
    this.seats = seats;
  }

  @Override
  public String toString() {
    return year + "年" + vendor + "客车," + seats + "座," + (isRent ? "已出租" : "未出租");
  }
}
