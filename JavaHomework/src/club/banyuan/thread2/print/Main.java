package club.banyuan.thread2.print;

import java.util.Arrays;
import java.util.List;

public class Main {

  public static void main(String[] args) throws InterruptedException {
    List<String> strings = Arrays.asList("How", "are", "you");  //1
    PrintThread p1 = new PrintThread(strings);
    PrintThread p2 = new PrintThread(Arrays.asList("fine", "thank", "you", "and", "you?"));//2
    PrintThread p3 = new PrintThread(Arrays.asList("I'm", "fine", "too")); //3

    p1.start();
     p1.join();
    p2.start();
     p2.join();
    p3.start();
     p3.join();

  }
}
