package binarysearch;

import org.junit.Assert;
import org.junit.Test;

public class Pow {

  private double myPowPositive(double x, long n) {
    if (n <= 1) {
      return x;
    }

    if (n % 2 == 1) {
      return x * myPowPositive(x * x, (n - 1) / 2);
    } else {
      return myPowPositive(x * x, n / 2);
    }
  }

  public double myPow(double x, int n) {
    if (n == 0) {
      return 1;
    } else if (n < 0) {
      return myPowPositive(1 / x, Math.abs((long)n));
    }
    return myPowPositive(x, n);
  }

  @Test
  public void case1() {
    Assert.assertEquals(1024, myPow(2.0000, 10), 0.001);
  }

  @Test
  public void case2() {
    Assert.assertEquals(9.2610, myPow(2.10000, 3), 0.001);
  }

  @Test
  public void case3() {
    Assert.assertEquals(0.2500, myPow(2.00000, -2), 0.001);
  }

  @Test
  public void case4() {
    Assert.assertEquals(0.00000, myPow(2.00000, -2147483648), 0.001);
  }

  @Test
  public void case5() {
    Assert.assertEquals(1.00000, myPow(0.44528, 0), 0.001);
  }
}
