package club.banyuan;

public enum Gender {
  MALE("男"), FEMALE("女"), ALIENS("外星人");

  private final String type;

  // 枚举类的构造方法都是默认private修饰
  Gender(String type) {
    this.type = type;
  }

  public String getType() {
    return type;
  }

  // public String name(){
  //   return "xxx";
  // }

  @Override
  public String toString() {
    return type;
  }

  public static Gender valueOfType(String str) {
    // values返回枚举类对象的集合
    Gender[] values = values();
    for (Gender value : values) {
      if (value.type.equals(str)) {
        return value;
      }
    }
    // 没找到匹配项
    return null;
    // if (FEMALE.type.equals(str)) {
    //   return FEMALE;
    // } else if (MALE.type.equals(str)) {
    //   return MALE;
    // } else {
    //   return null;
    // }
  }
}
