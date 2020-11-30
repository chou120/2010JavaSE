package club.banyuan.testJar;

import club.banyuan.cal.Calculator;
import cn.hutool.core.util.StrUtil;

/**
 * @author sanye
 * @version 1.0
 * @date 2020/11/29 2:01 下午
 */
public class Test {

  public static void main(String[] args) {
    Calculator.parseAndCompute("2132");

    System.out.println(StrUtil.isNotBlank("assd"));
    System.out.println("那会");

  }
}
