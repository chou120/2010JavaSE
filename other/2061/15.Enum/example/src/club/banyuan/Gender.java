package club.banyuan;

public class Gender {

  public static final Gender MALE = new Gender();
  public static final Gender FEMALE = new Gender();

  // 私有化构造方法，其他类不能创建对象。
  private Gender() {

  }

  // 对象到字符串的转换
  @Override
  public String toString() {
    if (this == MALE) {
      return "男";
    } else if (this == FEMALE) {
      return "女";
    } else {
      // 不应该出现这种情况
      return null;
    }
  }

  public static Gender valueOf(String str) {
    if ("男".equals(str)) {
      return MALE;
    } else if ("女".equals(str)) {
      return FEMALE;
    } else {
      return null;
    }
  }
}
