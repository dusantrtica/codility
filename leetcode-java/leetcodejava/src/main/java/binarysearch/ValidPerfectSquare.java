package binarysearch;

import org.junit.Assert;
import org.junit.Test;

public class ValidPerfectSquare {
  public boolean isPerfectSquare(int num) {
    if(num < 2) {
      return true;
    }
    long start = 2;
    long end = num/2;

    while(start <= end) {
      long mid = start + (end - start)/2;
      long midSqr = mid * mid;
      if(midSqr == num) {
        return  true;
      } else if (midSqr < num) {
        start = mid+1;
      } else {
        end = mid-1;
      }
    }
    return false;
  }

  @Test
  public void case1() {
    Assert.assertEquals(true, isPerfectSquare(16));
  }

  @Test
  public void case2() {
    Assert.assertEquals(false, isPerfectSquare(14));
  }

  @Test
  public void case3() {
    Assert.assertEquals(true, isPerfectSquare(25));
  }

  @Test
  public void case4() {
    Assert.assertEquals(true, isPerfectSquare(1));
  }

  @Test
  public void case5() {
    Assert.assertEquals(false, isPerfectSquare(2147483647));
  }

  @Test
  public void case6() {
    Assert.assertEquals(true, isPerfectSquare(808201));
  }
}
