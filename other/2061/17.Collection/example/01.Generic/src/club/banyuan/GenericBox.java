package club.banyuan;

// 数据类型的变量 = 类型参数 type parameter，泛型参数
// var = String
// 使用类型参数声明的类，叫做泛型类
// T type E element  K key  V value
public class GenericBox<T> {

  // 声明成员变量
  private T item;

  // 方法入参
  public void load(T item) {
    this.item = item;
  }

  // 方法返回值
  public T unload() {
    return item;
  }

  public void genericTest() {
    // 声明变量
    T t;
    // 不能用来创建对象。
    // t = new T();
  }

  public static void main(String[] args) {
    GenericBox<String> box = new GenericBox<>();
    box.load("1234");

    // box.load(123);

    String unload = box.unload();

    GenericBox<Box> genericBox = new GenericBox<>();
    genericBox.load(new Box());

    Box unload1 = genericBox.unload();
  }
}
