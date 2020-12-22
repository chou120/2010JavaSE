public class Main {

  public static void main(String[] args) {
    Thread thread = new Thread();
    System.out.println(thread.getName());
    System.out.println(thread.getId());
    System.out.println(thread.getPriority());
    System.out.println(thread.getState());

    Thread thread1 = new Thread();
    System.out.println(thread1.getName());
    System.out.println(thread1.getId());
    System.out.println(thread1.getPriority());
    System.out.println(thread1.getState());
    thread1.start();
    System.out.println(thread1.getState());

  }
}
