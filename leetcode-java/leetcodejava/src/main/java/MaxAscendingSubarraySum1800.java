import org.junit.Assert;
import org.junit.Test;

public class MaxAscendingSubarraySum1800 {
  public int maxAscendingSum(int[] nums) {
    int n = nums.length;
    int sum = nums[0];
    int maxSum = sum;
    for (int i = 1; i < n; i++) {
      if (nums[i - 1] < nums[i]) {
        sum += nums[i];
      } else {
        if (maxSum < sum) {
          maxSum = sum;
        }
        sum = nums[i];
      }
    }
    return Math.max(sum, maxSum);
  }

  @Test
  public  void case1() {
    Assert.assertEquals(65, maxAscendingSum(new int []{10,20,30,5,10,50}));
  }
}
