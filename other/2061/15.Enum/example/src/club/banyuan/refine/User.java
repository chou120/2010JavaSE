package club.banyuan.refine;

public class User {

  private String name;
  private int age;
  // 男 女
  private GenderRefine gender;

  public User(String name, int age, GenderRefine gender) {
    this.name = name;
    this.age = age;
    this.gender = gender;
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

  public GenderRefine getGender() {
    return gender;
  }

  public void setGender(GenderRefine gender) {
    this.gender = gender;
  }

  @Override
  public String toString() {
    return "User{" +
        "name='" + name + '\'' +
        ", age=" + age +
        ", gender='" + gender + '\'' +
        '}';
  }
}
