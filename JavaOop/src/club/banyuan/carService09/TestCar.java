package club.banyuan.carService09;

/**
 * @author sanye
 * @version 1.0
 * @date 2020/11/19 9:17 上午
 */
public class TestCar {

  public static void main(String[] args) {
    Park park = new Park();

    Car car = new Car();
    car.setBrand("别克");
    car.setCarId("10001");
    park.addCar(car);

    car = new Car();
    car.setBrand("别克");
    car.setCarId("10002");
    park.addCar(car);

    car = new Car();
    car.setBrand("大众");
    car.setCarId("10003");
    park.addCar(car);

//     Car[] buick = park.getByCarBrand("别克");
//    System.out.println(Arrays.toString(buick));
//
    park.showInfoAll();

    Car car1 = park.removeCar("10002");
    System.out.println("\n"+car1+"\n");
    park.showInfoAll();
  }
}
