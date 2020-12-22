package club.banyuan;// package club.banyuan;

import static org.junit.Assert.*;

import org.junit.Assert;

import org.junit.Test;

public class CalculatorExampleTest {

  // boolean parseAndCompute(String input)
  //  1 + 1  预期 false
  //  1+ 1 预期 false
  //  a + 1 预期 false
  // quit 预期 true

  @Test
  public void testParseAndCompute() {
    assertFalse(Calculator.parseAndCompute("1 + 1"));
    assertFalse(Calculator.parseAndCompute("1+ 1"));
    assertFalse(Calculator.parseAndCompute("a + 1"));
    assertTrue(Calculator.parseAndCompute("quit"));
    assertTrue(Calculator.parseAndCompute("QUIT"));
  }

  // int compute(String[] tokens)
  // {"0","+", "1"}   1
  // {"0", "1"}   异常
  // {"-", "1"}   -1
  // {"-", "1","5"} 输入异常
  // {"quIt"} Quit异常
  // {"123"}  输入异常
  @Test
  public void testCompute() throws CalculatorException {
    String[] tokens = {"0", "+", "1"};
    try {
      assertEquals(1, Calculator.compute(tokens));
      tokens = new String[]{"0", "1"};
      Calculator.compute(tokens);
      fail();
    } catch (CalculatorException e) {
      assertTrue(e instanceof IllegalInputException);
    }

    tokens = new String[]{"-", "1"};
    assertEquals(-1, Calculator.compute(tokens));
    tokens = new String[]{"quit"};
    try {
      Calculator.compute(tokens);
    } catch (CalculatorException e) {
      assertTrue(e instanceof QuitException);
    }
  }

  /**
   * 测试正确的情况
   */
  @Test
  public void computeAdditionTest1() {
    try {
      Assert.assertEquals("计算的结果错误", 9,
          Calculator.compute(new String[]{"4", "+", "5"}));
    } catch (Exception e) {
      Assert.fail("不应该抛出异常");
    }
  }

  /**
   * 测试退出
   */
  @Test
  public void computeQuitTest1() {
    try {
      Calculator.compute(new String[]{"quit"});
      Assert.fail("退出时应该抛出异常");
    } catch (QuitException e) {
      // Do nothing in this case
    } catch (Exception e) {
      Assert.fail("退出时应该抛出 QuitException");
    }
  }


  /**
   * Test Single Illegal Arg
   */
  @Test
  public void computeSingleIllegalArgTest() {
    try {
      Calculator.compute(new String[]{"foo"});
      Assert.fail("String \"foo\" 应该抛出异常");
    } catch (IllegalInputException e) {
      Assert.assertEquals("IllegalInputException 被生成, 消息内容必须为Illegal Argument", "Illegal input :Illegal Argument",
          e.getMessage());
    } catch (Exception e) {
      Assert.fail("String \"foo\" 应该生成 IllegalInputException");
    }
  }


  @Test
  public void parseAndComputeAddition() {
    Assert.assertFalse(
        Calculator.parseAndCompute("4 + 2"));
    Assert.assertTrue(
        Calculator.parseAndCompute("quit"));
  }

}
