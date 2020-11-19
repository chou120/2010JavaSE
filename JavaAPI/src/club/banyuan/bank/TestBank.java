package club.banyuan.bank;

/**
 * @author sanye
 * @version 1.0
 * @date 2020/11/19 4:13 下午
 */
public class TestBank {


  public static void main(String[] args) {
    Bank  bank=new Bank();
    bank.setName("今年");

    User user = new User();
    user.setIdCard("xxxx89");
    user.setName("89");
   // user.setNumber(9527);
    bank.addUser(user);

    User  user1 = new User();
    user1.setIdCard("xxxx8");
    user1.setName("8");
    bank.addUser(user1);

    System.out.println(bank);

  }

}
