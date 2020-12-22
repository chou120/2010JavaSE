package club.banyuan.print;

import java.util.Arrays;
import java.util.List;

public class Main {

  public static void main(String[] args) throws InterruptedException {
    List<String> strings = Arrays.asList("How", "are", "you");
    PrintThread p1 = new PrintThread(
        new PrintString(strings));
    PrintThread p2 = new PrintThread(
        new PrintString(Arrays.asList("fine", "thank", "you", "and", "you?")));
    PrintThread p3 = new PrintThread(
        new PrintString(Arrays.asList("I'm", "fine", "too")));

    p1.start();
    // p1.join();
    p2.start();
    // p2.join();
    p3.start();
    // p3.join();

  }
}
