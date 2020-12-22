public class Account {

  private int balance;
  private int accountNo;

  public int getBalance() {
    return balance;
  }

  public void setBalance(int balance) {
    this.balance = balance;
  }

  public int getAccountNo() {
    return accountNo;
  }

  public void setAccountNo(int accountNo) {
    this.accountNo = accountNo;
  }

  public void displayBalance() {
    System.out.println("银行账号:" + accountNo + "余额: " + balance);
  }

  /**
   * 存款
   *
   * @param amount
   */
  public void deposit(int amount) {
    balance = balance + amount;
    System.out.println("存入" + amount);
    displayBalance();
  }

  /**
   * 取款
   *
   * @param amount
   */
  public void withdraw(int amount) {
    balance = balance - amount;
    System.out.println("取出" + amount);
    displayBalance();
  }
}