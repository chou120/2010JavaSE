package club.service.entity;

import java.util.Date;

/**
 * @author sanye
 * @version 1.0
 * @date 2020/11/26 7:34 下午
 */
public class Product {

  private  String productName;//产品名称
  private  String number; //产品编号
  private Date date; //生产时间
  private String  address;//生产地
  private static int proId=1;

  public Product() {
    number=proId++ + "";
    date=new Date();
  }

  public Product(String productName, String number, Date date, String address) {
    this.productName = productName;
    this.number = number;
    this.date = date;
    this.address = address;
  }

  public String getProductName() {
    return productName;
  }

  public void setProductName(String productName) {
    this.productName = productName;
  }

  public String getNumber() {
    return number;
  }

  public void setNumber(String number) {
    this.number = number;
  }

  public Date getDate() {
    return date;
  }

  public void setDate(Date date) {
    this.date = date;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }
  @Override
  public String toString() {
    return "Product{" +
        "productName='" + productName + '\'' +
        ", number='" + number + '\'' +
        ", date=" + date +
        ", address='" + address + '\'' +
        '}';
  }
}
