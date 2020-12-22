package club.banyuan;

import java.util.Iterator;
import org.junit.Assert;
import org.junit.Test;

public class PairsTest {

  @Test
  public void test() {
    Pairs<String, Integer> pairs = new Pairs<>();
    for (int i = 0; i < 15; i++) {
      pairs.addPair("A" + i, i);
    }
    // Assert.assertTrue(pairs.iterator().hasNext());

    validateInit(pairs);

    /* 遍历并打印 */
    for (OnePair<String, Integer> pair : pairs) {
      System.out.println(pair.toString());
    }
    System.out.println();
    //
    Iterator<OnePair<String, Integer>> iterator = pairs.iterator();
    while (iterator.hasNext()) {
      OnePair<String, Integer> pair = iterator.next();
      /* 删除偶数位置的内容 */
      if ((pair.getSecond() % 2) == 0) {
        iterator.remove();
      }
    }

    validateRemove(pairs);
    //
    // /* 再次迭代并打印剩余的 */
    // for (OnePair<String, Integer> pair : pairs) {
    //   System.out.println(pair.toString());
    // }
    // System.out.println();
    //
    /* 现在重新添加一些内容并确认已添加 */
    pairs.addPair("B", 10);

    for (OnePair<String, Integer> pair : pairs) {
      System.out.println(pair.toString());
    }
    System.out.println();

    validateAdd(pairs);

  }

  private void validateAdd(Pairs<String, Integer> pairs) {
    Iterator<OnePair<String, Integer>> iterator = pairs.iterator();
    boolean isContains = false;
    while (iterator.hasNext()) {
      OnePair<String, Integer> next = iterator.next();
      if (next.equals(new OnePair<>("B", 10))) {
        isContains = true;
        break;
      }
    }
    Assert.assertTrue(isContains);
  }

  private void validateRemove(Pairs<String, Integer> pairs) {
    Iterator<OnePair<String, Integer>> iterator = pairs.iterator();
    int count = 1;
    while (iterator.hasNext()) {
      OnePair<String, Integer> next = iterator.next();
      Assert.assertEquals(new OnePair<>("A" + count, count), next);
      count += 2;
    }
  }

  private void validateInit(Pairs<String, Integer> pairs) {
    Iterator<OnePair<String, Integer>> iterator = pairs.iterator();
    int count = 0;
    while (iterator.hasNext()) {
      Assert.assertEquals(new OnePair<>("A" + count, count), iterator.next());
      count++;
    }
    Assert.assertEquals(10, count);
  }
}
