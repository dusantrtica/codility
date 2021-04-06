import org.junit.Assert;
import org.junit.Test;

public class NonDecreasingArray665 {

  public boolean checkPossibility(int[] nums) {
    int n = nums.length;
    if (n == 1 || n == 2) {
      return true;
    }

    boolean fixed = false;
    for (int i = 1; i < n; i++) {
      if (nums[i - 1] > nums[i]) {
        if (fixed) {
          return false;
        }

        if (i == 1 || nums[i - 2] <= nums[i]) {
          nums[i - 1] = nums[i];
        } else {
          nums[i] = nums[i - 1];
        }

        fixed = true;
      }
    }
    return true;
  }

  @Test
  public void case1() {
    int[] nums = {4, 2, 3};
    Assert.assertEquals(true, checkPossibility(nums));
  }

  @Test
  public void case2() {
    int[] nums = {4, 2, 1};
    Assert.assertEquals(false, checkPossibility(nums));
  }

  @Test
  public void case3() {
    int[] nums = {3, 4, 2, 3};
    Assert.assertEquals(false, checkPossibility(nums));
  }

  @Test
  public void case4() {
    int [] nums = {1,4,1,2};
    Assert.assertEquals(true, checkPossibility(nums));
  }

}
