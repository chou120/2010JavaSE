package club.banyuan.service;

/**
 * @author sanye
 * @version 1.0
 * @date 2020/11/30 1:55 下午
 */
public enum Gender {

  MALE("男"),FEMALE("女");

  private  String  name;

  Gender(String  name) {
    this.name=name;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Override
  public String toString() {
    return "Gender{" +
        "name='" + name + '\'' +
        '}';
  }
}
