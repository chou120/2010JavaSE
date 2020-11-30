package club.banyuan.demo;

/**
 * @author sanye
 * @version 1.0
 * @date 2020/11/29 1:09 下午
 */
public class InsufficientFundsException extends Exception {

  //此处的amount用来储存当出现异常（取出钱多于余额时）所缺乏的钱
  private double amount;

  public InsufficientFundsException(double amount) {
    this.amount = amount;
  }

  public double getAmount() {
    return amount;
  }
}

class CheckingAccount {

  //balance为余额，number为卡号
  private double balance;
  private int number;

  public CheckingAccount(int number) {
    this.number = number;
  }

  //方法：存钱
  public void deposit(double amount) {
    balance += amount;
  }

  //方法：取钱
  public void withdraw(double amount) throws InsufficientFundsException {
    if (amount <= balance) {
      balance -= amount;
    } else {
      double needs = amount - balance;
      throw new InsufficientFundsException(needs);
      //在这里通过throw关键字我们主动抛出之前自定义的异常，也就是说如果取的钱要大于余额的话我们就抛出一个异常，相当于当前情况下自动产生异常
    }
  }

  //方法：返回余额
  public double getBalance() {
    return balance;
  }

  //方法：返回卡号
  public int getNumber() {
    return number;
  }
}

class BankDemo {

  public static void main(String[] args) {
    CheckingAccount c = new CheckingAccount(101);
    System.out.println("Depositing $500...");
    c.deposit(500.00);
    try {
      System.out.println("\n Withdrawing $100...");
      c.withdraw(100.00);
      System.out.println("\n Withdrawing $600...");
      c.withdraw(600.00);//这里在执行withdraw方法的时候会抛出异常
    } catch (InsufficientFundsException e) {
      System.out.println("Sorry, but you are short $" + e.getAmount());
      e.printStackTrace();
    }
  }
}