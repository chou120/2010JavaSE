public class Main {

  public static void main(String args[]) {
    Account a = new Account();
    a.setAccountNo(111);
    a.setBalance(1000);
    DepositThread t1;
    WithdrawThread t2;
    t1 = new DepositThread(a, 500);
    t2 = new WithdrawThread(a, 900);

    for (int i = 0; i < 10; i++) {
      new Thread(t1).start();
      new Thread(t2).start();
    }
  }
}
