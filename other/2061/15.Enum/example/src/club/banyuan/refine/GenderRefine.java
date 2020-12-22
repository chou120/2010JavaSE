package club.banyuan.refine;

public class GenderRefine {

  public static final GenderRefine MALE = new GenderRefine("男");
  public static final GenderRefine FEMALE = new GenderRefine("女");

  private String type;

  // 私有化构造方法，其他类不能创建对象。
  private GenderRefine(String type) {
    this.type = type;
  }

  // 对象到字符串的转换
  @Override
  public String toString() {
    return this.type;
  }

  public static GenderRefine valueOf(String str) {
    if (MALE.type.equals(str)) {
      return MALE;
    } else if (FEMALE.type.equals(str)) {
      return FEMALE;
    } else {
      return null;
    }
  }
}
