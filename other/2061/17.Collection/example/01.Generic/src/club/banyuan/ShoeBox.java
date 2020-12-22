package club.banyuan;

public class ShoeBox<T extends Shoe> {

  private T item;

  public T getItem() {
    return item;
  }

  public void setItem(T item) {
    this.item = item;
  }

  // 泛型指定的数据类型不一致不构成重载
  public static void unbox(ShoeBox<?> shoeBox) {
    Shoe item = shoeBox.getItem();
    System.out.println(item);
  }

  // public static ShoeBox<?> getBox() {
  //   return new ShoeBox<>();
  // }

  // public static ShoeBox<? super Shoe> getBox() {
  //   return new ShoeBox<>();
  // }

  public static ShoeBox<? extends Shoe> getBox() {
    return new ShoeBox<>();
  }

  //
  // public static void unbox(ShoeBox<? super Shoe> shoeBox) {
  //   Shoe item = shoeBox.getItem();
  //   System.out.println(item);
  // }

  // public static void unbox(ShoeBox<? extends SportShoe> shoeBox) {
  //   Shoe item = shoeBox.getItem();
  //   System.out.println(item);
  // }

  // public static void unbox(ShoeBox<Shoe> shoeBox) {
  //   Shoe item = shoeBox.getItem();
  //   System.out.println(item);
  // }

  public static void main(String[] args) {
    ShoeBox<Shoe> shoeBox = new ShoeBox<>();
    shoeBox.setItem(new SportShoe());
    shoeBox.setItem(new Shoe());
    shoeBox.setItem(new HighHeeledShoe());

    // ShoeBox<Integer> shoeBox1 = new ShoeBox<>();
    // shoeBox1.setItem(123);

    ShoeBox<SportShoe> sportShoeShoeBox = new ShoeBox<>();

    unbox(shoeBox);
    // unbox(sportShoeShoeBox);

    // ShoeBox<? extends Shoe> box = getBox();
    // box.setItem(new Shoe());
  }
}
