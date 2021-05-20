import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;

public class SlidingWindowMax239 {

  int maxSubArray (int [] arr, int low, int high) {
    int max = arr[low];
    for(int i = low+1; i <= high; i++) {
      if(arr[i] > max) {
        max = arr[i];
      }
    }
    return max;
  }
  public int[] maxSlidingWindow(int[] nums, int k) {
    int n = nums.length;
    int [] result = new int [n-k+1];

    for(int i = 0; i + k <= n; i++) {
      result[i] = maxSubArray(nums, i, i+k-1);
    }
    return result;
  }

  @Test
  public void case1() {
    Assert.assertArrayEquals(new int[]{3, 3, 5, 5, 6, 7}, maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3));
  }

  @Test
  public void case2() {
    Assert.assertArrayEquals(new int[]{1}, maxSlidingWindow(new int[]{1}, 1));
  }

  @Test
  public void case3() {
    Assert.assertArrayEquals(new int[]{1, -1}, maxSlidingWindow(new int[]{1, -1}, 1));
  }

  @Test
  public void case4() {
    Assert.assertArrayEquals(new int[]{11}, maxSlidingWindow(new int[]{9, 11}, 2));
  }

  @Test
  public void case5() {
    Assert.assertArrayEquals(new int[]{4}, maxSlidingWindow(new int[]{4, -2}, 2));
  }
}
