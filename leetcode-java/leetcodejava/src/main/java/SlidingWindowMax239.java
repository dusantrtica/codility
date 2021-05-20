import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import org.junit.Assert;
import org.junit.Test;

public class SlidingWindowMax239 {
  public int[] maxSlidingWindow(int[] nums, int k) {
    PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> Integer.compare(o2, o1));
    int n = nums.length;
    int [] result = new int [n-k+1];

    for(int i = 0; i < k; i++) {
      queue.add(nums[i]);
    }

    result[0] = queue.peek();

    for(int i = 1; i + k <= n; i++) {
      queue.remove(nums[i-1]);
      queue.add(nums[i+k-1]);
      result[i] = queue.peek();
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
