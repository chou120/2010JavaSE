###  程序启动在控制台显示
      *** 欢迎来到半圆租车系统 ***
      1.添加入库车辆
      2.移除入库车辆
      3.查询所有的入库车辆信息
      4.查询满足所有的汽车品牌为 别克 的所有的车辆信息
      5.退出租车系统

### 添加车辆,由于现实生活中汽车在车库中的位置随便停,所以在车辆入库的时候要考虑车辆停的位置
   public  void  addCar(Car car){
    //TODO
   }
### 根据汽车牌照,出库车辆
  public  Car  removeCar(String carId){

  }

### 查询所有入库的车辆信息
  public  void  showInfoAll(){

  }

###   查询满足所有的汽车品牌为 别克 的所有的车辆信息
  public  Car[] getByCarBrand(String brand){

  }

需求:
  1.在每次做完添加之后,如果选择其他的功能也可以实现该功能
  2.System.exit(0);退出租车系统