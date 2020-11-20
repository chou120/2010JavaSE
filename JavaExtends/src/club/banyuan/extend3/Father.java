package club.banyuan.extend3;

/**
 * @author sanye
 * @version 1.0
 * @date 2020/11/20 9:42 上午
 */
public class Father {

  private  String  name="老爹";
  int  age=56;
  protected  String address="家住大东北";
  public  String   IdCard="1231231231x";


  void  getMoney(){
    System.out.println("这是父类的赚钱默认的方法...");
  }
  protected void protectWife(){
    System.out.println("这是父类的保护老婆的protected的方法");
  }
  private  void  savePrivateMoney(){
    System.out.println("private 藏私房钱...");
  }


  public Father() {
  }

  public Father(String name, int age, String address, String idCard) {
    this.name = name;
    this.age = age;
    this.address = address;
    IdCard = idCard;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public String getIdCard() {
    return IdCard;
  }

  public void setIdCard(String idCard) {
    IdCard = idCard;
  }

  @Override
  public String toString() {
    return "Father{" +
        "name='" + name + '\'' +
        ", age=" + age +
        ", address='" + address + '\'' +
        ", IdCard='" + IdCard + '\'' +
        '}';
  }
}


class  Test{
  public static void main(String[] args) {
    Father father = new Father();
    father.setName("ads");
  }
}