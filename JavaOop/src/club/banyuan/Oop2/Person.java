package club.banyuan.Oop2;

/**
 * @author sanye
 * @version 1.0
 * @date 2020/11/17 11:08 上午
 */
public class Person {

  private  String  name;
  private  String IDCard;
  private  String  address;

  public String getName() {
    return name;
  }

  public void setName(String name) {
//  TODO 自己可在设置数据的时候进行判断
    this.name = name;
  }
  public String getIDCard() {
    return IDCard;
  }
  public void setIDCard(String IDCard) {
    this.IDCard = IDCard;
  }
  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  @Override
  public String toString() {
    return "Person{" +
        "name='" + name + '\'' +
        ", IDCard='" + IDCard + '\'' +
        ", address='" + address + '\'' +
        '}';
  }
}
