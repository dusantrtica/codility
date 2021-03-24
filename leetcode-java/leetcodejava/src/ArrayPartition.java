import java.util.Arrays;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import org.junit.Assert;
import org.junit.Test;

public class ArrayPartition {

  public int arrayPairSum(int[] nums) {
    Arrays.sort(nums);
    int n = nums.length;

    int maxSum = 0;
    for(int i = 0; i < n; i += 2) {
      maxSum += nums[i];
    }
    return maxSum;
  }

  @Test
  public void case1() {
    int[] nums = {1, 4, 3, 2};
    Assert.assertEquals(4, arrayPairSum(nums));
  }

  @Test
  public void case2() {
    int[] nums = {6, 2, 6, 5, 1, 2};
    Assert.assertEquals(9, arrayPairSum(nums));
  }
}
