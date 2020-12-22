package club.banyuan;

public class Item {

  private String name;

  public Item(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Override
  public boolean equals(Object obj) {
    if (obj instanceof Item) {
      return name.charAt(0) == ((Item) obj).getName().charAt(0);
    }
    return false;
  }

  @Override
  public String toString() {
    return "Item{" +
        "name='" + name + '\'' +
        '}';
  }
}
