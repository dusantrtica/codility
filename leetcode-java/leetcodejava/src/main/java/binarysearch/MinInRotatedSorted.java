package binarysearch;

import org.junit.Assert;
import org.junit.Test;

public class MinInRotatedSorted {

  public int findMin(int [] nums) {
    int n = nums.length;
    if(n == 1) {
      return nums[0];
    }
    int start = 0;
    int end = n-1;
    while(start <= end) {
      int mid = (start + end)/2;
      if(nums[mid] > nums[mid+1]) {
        return nums[mid+1];
      } else if(nums[mid] > nums[end]) {
        start = mid + 1;
      } else {
        end = mid - 1;
      }
    }

    return nums[start];
  }

  @Test
  public void case1() {
    Assert.assertEquals(1, findMin(new int[]{3, 4, 5, 1, 2}));
  }

  @Test
  public void case2() {
    Assert.assertEquals(0, findMin(new int[]{4, 5, 6, 7, 0, 1, 2}));
  }

  @Test
  public void case3() {
    Assert.assertEquals(11, findMin(new int[]{11, 13, 15, 17}));
  }

  @Test
  public void case4() {
    Assert.assertEquals(1, findMin(new int []{1}));
  }

  @Test
  public void case5() {
    Assert.assertEquals(1, findMin(new int []{1,2}));
  }
  @Test
  public  void case6() {
    Assert.assertEquals(1, findMin(new int []{2,1}));
  }
}
