package club.banyuan;

public class Box {

  private Object item;

  public void load(Object item) {
    this.item = item;
  }

  public Object unload() {
    return item;
  }


  // 让容器记录数据类型
  // 这样从容器取出数据的时候，可以不需要进行类型转换
  // 在使用容器的时候，让编译器进行类型的检查
  public static void main(String[] args) {
    Box box = new Box();
    box.load(123);
    Object unload = box.unload();
    Integer integer = (Integer) unload;
    System.out.println(integer.intValue());

    box.load("abcd");
    unload = box.unload();
    System.out.println(((String) unload).toUpperCase());

    box.load(new Box());
    unload = box.unload();

  }
}
