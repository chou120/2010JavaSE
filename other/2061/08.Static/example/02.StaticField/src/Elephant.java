public class Elephant {

  // 静态成员的内存区域的分配，是在类加载后，立刻为静态成员分配
  // 触发类的加载，传递到java中的类
  // new Elephant() 创建对象的时候，先检查类有没有被加载过，如果没有被加载，就加载这个类
  // 使用类名调用静态方法，或使用静态成员的时候，触发类的加载
  // Elephant elphant; 单纯的声明类的变量，不会触发类的加载
  private static int idBase = getIdBase();
  private int heightInCM = 300;

  static {
    System.out.println("类加载");
  }

  private int id;

  private static int getIdBase() {
    System.out.println("getIdBase");
    return 1;
  }

  public Elephant(int heightInCM, int id) {
    this.heightInCM = heightInCM;
    this.id = id;
  }

  public Elephant(int heightInCM) {
    this.heightInCM = heightInCM;
    this.id = idBase++;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public int getHeightInCM() {
    return heightInCM;
  }

  public void setHeightInCM(int heightInCM) {
    this.heightInCM = heightInCM;
  }

  public void printInfo() {
    System.out.println("大象的信息是：" + heightInCM);
  }

  public static void printInfo(Elephant elephant) {
    System.out.println("大象的信息是：" + elephant.heightInCM);
  }

  public static void main(String[] args) {
    // OtherCls.staticMethod();
    // OtherCls otherCls = new OtherCls();

    // int i = 1;
    // Elephant e1 = new Elephant(100, i++);
    // Elephant e2 = new Elephant(200, i++);
    // Elephant e3 = new Elephant(300, i++);
    // Elephant e4 = new Elephant(400, i++);
    // System.out.println(e1.getId() + ":" + e1.getHeightInCM());
    // System.out.println(e2.getId() + ":" + e2.getHeightInCM());
    // System.out.println(e3.getId() + ":" + e3.getHeightInCM());
    // System.out.println(e4.getId() + ":" + e4.getHeightInCM());
    //
    // Elephant e11 = new Elephant(100);
    // Elephant e22 = new Elephant(200);
    // Elephant e33 = new Elephant(300);
    // Elephant e44 = new Elephant(400);
    // System.out.println(e11.getId() + ":" + e11.getHeightInCM());
    // System.out.println(e22.getId() + ":" + e22.getHeightInCM());
    // System.out.println(e33.getId() + ":" + e33.getHeightInCM());
    // System.out.println(e44.getId() + ":" + e44.getHeightInCM());
  }
}
