package club.banyuan;

public class Truck extends Vehicle {

  int load;

  public Truck(String vendor, int year, int load) {
    super(vendor, year);
    this.load = load;
  }

  @Override
  public String toString() {
    return year + "年" + vendor + "货车," + "载重量" + load + "吨," + (isRent ? "已出租" : "未出租");
  }
}
