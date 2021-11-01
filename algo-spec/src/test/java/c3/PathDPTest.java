package c3;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

public class PathDPTest {

  PathDP pathDP = new PathDP();

  @Test
  public void case1() {
    Assert.assertEquals(8, pathDP.maxWeightPathNoAdj(new int[]{1, 4, 5, 4}));
  }

  @Test
  public void case2() {
    Assert.assertEquals(3, pathDP.maxWeightPathNoAdj(new int[]{1,3,1}));
  }

  @Test
  public void case3() {
    Assert.assertEquals(5, pathDP.maxWeightPathNoAdj(new int[]{4,5}));
  }

  @Test
  void case4() {
    Assert.assertEquals(10, pathDP.maxWeightPathNoAdj(new int []{10, 1}));
  }
}
