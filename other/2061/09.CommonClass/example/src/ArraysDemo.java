import java.util.Arrays;

public class ArraysDemo {

  public static void main(String[] args) {
    int[] a = new int[]{1, 2, 3, 4, 5};
    System.out.println(a);
    System.out.println(Arrays.toString(a));

    Arrays.fill(a, 4);
    System.out.println(Arrays.toString(a));

    int[] newArr = Arrays.copyOf(a, 20);
    System.out.println(Arrays.toString(newArr));

  }
}
