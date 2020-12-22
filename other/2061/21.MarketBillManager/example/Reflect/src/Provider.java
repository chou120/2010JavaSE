public class Provider {

  private int id;
  private String name;
  private String desc;

  public Provider(int id, String name, String desc) {
    this.id = id;
    this.name = name;
    this.desc = desc;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDesc() {
    return desc;
  }

  public void setDesc(String desc) {
    this.desc = desc;
  }

  public static void staticMethod() {
    System.out.println("staticMethod");
  }

  @Override
  public String toString() {
    return "Provider{" +
        "id=" + id +
        ", name='" + name + '\'' +
        ", desc='" + desc + '\'' +
        '}';
  }
}
