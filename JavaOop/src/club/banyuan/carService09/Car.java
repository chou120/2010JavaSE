package club.banyuan.carService09;

/**
 * @author sanye
 * @version 1.0
 * @date 2020/11/19 9:05 上午
 */
public class Car {

  private String carId;//汽车牌照
  private String brand;//汽车品牌

  public String getCarId() {
    return carId;
  }

  public void setCarId(String carId) {
    this.carId = carId;
  }

  public String getBrand() {
    return brand;
  }

  public void setBrand(String brand) {
    this.brand = brand;
  }

  @Override
  public String toString() {
    return "Car{" +
        "carId='" + carId + '\'' +
        ", brand='" + brand + '\'' +
        '}';
  }
}
