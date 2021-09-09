package binarysearch;

import org.junit.Assert;
import org.junit.Test;

public class FindPeakElement {

  public int findPeakElement(int[] nums) {
    int len = nums.length;
    if (len == 1) {
      return 0;
    }
    if (nums[0] > nums[1]) {
      return 0;
    } else if (nums[len - 2] < nums[len - 1]) {
      return len - 1;
    }

    int start = 0;
    int end = len - 1;
    while (true) {
      int mid = (start + end) / 2;
      int midElem = nums[mid];
      if(midElem < nums[mid+1]) {
        start = mid;
      } else if (midElem < nums[mid-1]) {
        end = mid;
      } else {
        return mid;
      }
    }
  }

  @Test
  public void case1() {
    Assert.assertEquals(2, findPeakElement(new int[]{1, 2, 3, 1}));
  }

  @Test
  public void case2() {
    Assert.assertEquals(5, findPeakElement(new int[]{1, 2, 1, 3, 5, 6, 4}));
  }

  @Test
  public void case3() {
    Assert.assertEquals(0, findPeakElement(new int[]{1}));
  }

  @Test
  public void case4() {
    Assert.assertEquals(0, findPeakElement(new int[]{4, 3, 2, 1, 5}));
  }

  @Test
  public void case5() {
    Assert.assertEquals(3, findPeakElement(new int[]{1, 2, 3, 4}));
  }

  @Test
  public void case6() {
    Assert.assertEquals(1, findPeakElement(new int[]{3, 4, 3, 2, 1}));
  }

  @Test
  public void case7() {
    Assert.assertEquals(4, findPeakElement(new int[]{1, 2, 3, 4, 5, 4}));
  }

  @Test
  public void case8() {
    Assert.assertEquals(1, findPeakElement(new int[]{1, 6, 5, 4, 3, 2, 1}));
  }
}
