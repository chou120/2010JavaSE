package club.banyuan.carService09;

import java.util.Arrays;

/**
 * @author sanye
 * @version 1.0
 * @date 2020/11/19 9:06 上午
 */
public class Park {

  //用来存放汽车的容器
  private Car[] cars; //20

  //计数器  用来统计入库车辆数
  private int count = 0;

  {
    cars = new Car[20];    //创建20个长度的数组
  }

  public Car[] getCars() {
    return cars;
  }
  public void setCars(Car[] cars) {
    this.cars = cars;
  }

  // ### 添加车辆,由于现实生活中汽车在车库中的位置随便停,所以在车辆入库的时候要考虑车辆停的位置
  public void addCar(Car car) {
    //TODO
    //首先要找一个空位
    for (int i = 0; i < cars.length; i++) { //0~19
      //随机找位置  2  3  2  3
      int index = (int) (Math.random() * cars.length);  //随机数组下标
      //  19 满了  但是还有一个位置  随机数可能随机不到
      if (cars[index] != null) {
        i--;  //如果一直有一个位置随机不到  但是随着循环 i的增加 可能会一直停不进去  i--
        continue;
      } else {
        //否则就直接添加
        cars[index] = car;  //做添加
        break; //只要添加进去了就直接退出循环
      }
    }
    count++;
  }

  //### 根据汽车牌照,出库车辆
  public Car removeCar(String carId) {
    Car car = null;
    for (int i = 0; i < cars.length; i++) {
      if (cars[i] != null && cars[i].getCarId().equals(carId)) {
        car = cars[i];
        //移除车子
        cars[i]=null;
        break;
      }
    }
    return car;
  }

  //### 查询所有入库的车辆信息
  public void showInfoAll() {
    for (int i = 0; i < cars.length; i++) {
      if (cars[i] != null) {
        System.out.println(cars[i]);
      }
    }
  }

  //用来统计车库里面一共有多少辆车
  public int getCount() {
    return count;
  }


  //###   查询满足所有的汽车品牌为 别克 的所有的车辆信息
  public Car[] getByCarBrand(String brand) {
    Car[] cars1 = new Car[0];

    for (int i = 0; i < cars.length; i++) {
      if (cars[i] != null && cars[i].getBrand().equals(brand)) {
        cars1 = Arrays.copyOf(cars1, cars1.length + 1);
        cars1[cars1.length - 1] = cars[i];
      }
    }
    return cars1;
  }

//  需求:
//      1.在每次做完添加之后,如果选择其他的功能也可以实现该功能
//  2.System.exit(0);退出租车系统


}
