package binarysearch;

import org.junit.Assert;
import org.junit.Test;

public class Sqrt {

  public int mySqrt(int x) {
    if(x<2) {
      return x;
    }

    int start = 2;
    int end = x/2;

    long result;

    while(start<=end) {
      int mid = start + (end - start) / 2;
      result = (long)mid*mid;
      if(result >x) {
        end  = mid -1;
      } else if (result <x) {
        start = mid +1;
      } else {
        return mid;
      }
    }
    return end;
  }

  @Test
  public void case1() {
    Assert.assertEquals(2, mySqrt(4));
  }

  @Test
  public void case2() {
    Assert.assertEquals(2, mySqrt(8));
  }

  @Test
  public void case3() {
    Assert.assertEquals(1, mySqrt(1));
  }

  @Test
  public void case4() {
    Assert.assertEquals(3, mySqrt(10));
  }

  @Test
  public void case5() {
    Assert.assertEquals(46339, mySqrt(2147395599));
  }

  @Test
  public void case6() {
    Assert.assertEquals(46340, mySqrt(2147483647));
  }
}
