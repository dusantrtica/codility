package c3;

import java.util.List;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.spockframework.util.Pair;

public class KnapsackTest {
  Knapsack solution = new Knapsack();

  @Test
  public void case1() {
    List<Pair<Integer, Integer>> items = List.of(
        Pair.of(3,4),
        Pair.of(2,3),
        Pair.of(4,2),
        Pair.of(4,3)
    );
    int W = 6;

    Assert.assertEquals(8, solution.knapsack(W, items));
  }
}
