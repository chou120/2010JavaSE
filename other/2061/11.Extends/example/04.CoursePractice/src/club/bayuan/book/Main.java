package club.bayuan.book;

public class Main {

  public static void main(String[] args) {
    EBook eBook = new EBook("百年孤独", 399, 50, 500);

    PaperBook paperBook = new PaperBook("Thinking in Java", 99, 40, 1000);

    System.out.println(eBook.getProfit());
    System.out.println(paperBook.getProfit());
  }
}
