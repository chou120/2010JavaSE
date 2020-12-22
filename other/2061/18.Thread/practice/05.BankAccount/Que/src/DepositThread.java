public class DepositThread implements Runnable {

  private final int amount;
  private final Account account;

  DepositThread(Account x, int amount) {
    account = x;
    this.amount = amount;
  }

  public void run() {
    try {
      Thread.sleep(50);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    account.deposit(amount);
  }
}