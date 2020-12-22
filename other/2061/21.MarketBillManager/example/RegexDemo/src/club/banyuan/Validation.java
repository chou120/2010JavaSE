package club.banyuan;

public class Validation {

  public static void main(String[] args) {
    String name = "a1234567";
    // 首字母不能为数字
    // 只能包含 数字字母下划线
    // 长度不低于6位，不高于20位
    String regex = "[A-Za-z_][A-Za-z0-9_]{5,19}";

    // 手机号
    String phoneRegex = "1[3456789][0-9]{9}";


    if (name.matches(regex)) {
      // 正常的
      System.out.println("ok");
    } else {
      // 异常
      System.out.println("fail");
    }

    String target = "abcdefg......123457890_";
    if (name.length() <= 5 || name.length() > 20) {
      // 异常
    } else {

      for (char c : name.toCharArray()) {
        if (!target.contains(c + "")) {
          // 异常
        }
      }

      if ('0' <= name.charAt(0) && '9' >= name.charAt(0)) {
        // 异常
      }

    }
  }
}
