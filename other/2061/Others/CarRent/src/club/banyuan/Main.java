package club.banyuan;

import java.util.Scanner;

public class Main {

  public static final int CAPACITY = 20;
  static Vehicle[] vehicle = new Vehicle[CAPACITY];
  private static int carCount;
  static Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) {

    System.out.println("欢迎使用半圆租车系统");

    while (true) {
      printMenu();
      Scanner scanner = new Scanner(System.in);
      String input = scanner.nextLine();
      switch (input) {
        case "1":
          // 添加车辆
          addVehicle();
          break;
        case "2":
          // 打印车辆信息
          printInfo();
          break;
        case "3":
          // 出租车辆
          rentVehicle();
          break;
        case "4":
          // 归还车辆
          returnVehicle();
          break;
        case "0":
          // 退出
          System.out.println("谢谢使用，再见！");
          return;
        default:
          // 输入有误
          System.out.println("输入不合法！请重新输入");
      }
    }
  }

  private static void printMenu() {
    System.out.println("================");
    System.out.println("1. 添加车辆");
    System.out.println("2. 查询车辆");
    System.out.println("3. 出租车辆");
    System.out.println("4. 归还车辆");
    System.out.println("0. 退出系统");
  }

  private static void returnVehicle() {
    System.out.println("请选择租用的车辆编号(0返回上一级):");
    printInfoForRent(true);
    int index = RentScanner.getInt() - 1;
    if (index == -1) {
      return;
    }
    if (index >= carCount || index < 0 || !vehicle[index].isRent) {
      System.out.println("编号不合法");
    } else {
      vehicle[index].isRent = false;
      System.out.println("操作成功！");
      System.out.println(vehicle[index]);
    }
  }

  private static void rentVehicle() {
    System.out.println("请选择租用的车辆编号(0返回上一级):");
    printInfoForRent(false);
    int index = RentScanner.getInt() - 1;
    if (index == -1) {
      return;
    }
    if (index >= carCount || index < 0 || vehicle[index].isRent) {
      System.out.println("编号不合法");
    } else {
      vehicle[index].isRent = true;
      System.out.println("操作成功！");
      System.out.println(vehicle[index]);
    }
  }

  private static void printInfoForRent(boolean printByRent) {
    for (int i = 0; i < carCount; i++) {
      if (vehicle[i].isRent == printByRent) {
        System.out.println(i + 1 + ". " + vehicle[i]);
      }
    }
  }

  private static void printInfo() {
    for (int i = 0; i < carCount; i++) {
      System.out.println(i + 1 + ". " + vehicle[i]);
    }
  }

  private static void addVehicle() {
    if (carCount > CAPACITY) {
      System.out.println("车位已满");
      return;
    }
    int year = RentScanner.getYear();

    System.out.println("请输入车辆厂家：");
    String vendor = scanner.nextLine();

    System.out.println("请输入要添加的车辆类型 1.客车 2.货车");
    String carType = scanner.nextLine();
    if ("1".equals(carType)) {
      int seats = RentScanner.getInt("请输入客车载客量：");
      vehicle[carCount++] = new Car(vendor, year, seats);
    } else if ("2".equals(carType)) {
      int load = RentScanner.getInt("请输入卡车的载重量：");
      vehicle[carCount++] = new Truck(vendor, year, load);
    } else {
      System.out.println("输入不合法");
    }
    System.out.println("添加成功!");
    System.out.println(vehicle[carCount - 1]);
  }


}
