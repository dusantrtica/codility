package binarysearch;

import org.junit.Assert;
import org.junit.Test;

public class BinSearch {

  public int search(int[] nums, int target) {
    int start = 0;
    int end = nums.length - 1;

    int found = -1;

    while (true) {
      if (start >= end) {
        found = nums[start] == target ? start : -1;
        break;
      }
      int mid = (start + end) / 2;
      if (nums[mid] == target) {
        found = mid;
        break;
      } else if (nums[mid] < target) {
        start = mid+1;
      } else {
        end = mid-1;
      }
    }

    return found;
  }

  @Test
  public void case1() {
    Assert.assertEquals(-1, search(new int []{-1,0,3,5,9,12}, 2));
  }

  @Test
  public void case2() {
    Assert.assertEquals(2, search(new int []{-1,0,3,5,9,12}, 3));
  }

  @Test
  public void case3() {
    Assert.assertEquals(0, search(new int []{5}, 5));
  }

  @Test
  public void case4() {
    Assert.assertEquals(-1, search(new int []{}, 5));
  }
}
