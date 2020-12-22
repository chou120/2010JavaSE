package club.banyuan;

import static org.junit.Assert.*;

import java.util.Arrays;
import org.junit.Test;

public class TestRecommend {

  @Test
  public void testRecommend() {
    PersonalRecommender recommender = new PersonalRecommender();
    recommender.addLikes("张三", "A");
    recommender.addLikes("张三", "B");
    recommender.addLikes("张三", "C");
    recommender.addLikes("李四", "A");
    recommender.addLikes("李四", "1");
    recommender.addLikes("李四", "2");
    recommender.addLikes("王五", "D");

    assertTrue(recommender.likeBoth("李四", "1", "C"));
    assertFalse(recommender.likeBoth("王五", "D", "1"));
    assertTrue(
        recommender.recommendByPerson("李四").containsAll(Arrays.asList("A", "B", "C", "1", "2")));
    assertTrue(
        recommender.recommendByProject("2").containsAll(Arrays.asList("A", "1")));
    assertTrue(recommender.recommendByProject("D").isEmpty());
  }
}
