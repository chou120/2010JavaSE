public class PersonMain {

  public static void main(String[] args) {
    Person father = new Person();
    father.name = "zhangsan";
    Person son = new Person();
    son.name = "LiSi";
    son.age = 10;
    son.sex = "男";
    son.father = father;
    son.print();
    father.print();
  }
}
