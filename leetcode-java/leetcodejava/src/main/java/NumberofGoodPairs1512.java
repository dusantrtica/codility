import java.util.Arrays;
import org.junit.Assert;
import org.junit.Test;

public class NumberofGoodPairs1512 {

  public int numIdenticalPairs(int[] nums) {
    int n = nums.length;
    if (n < 2) {
      return 0;
    }
    Arrays.sort(nums);

    int totalIdentical = 0;
    int localIdentical = 1;
    for (int i = 0; i < n - 1; i++) {
      while (i+1 < n && nums[i] == nums[i + 1]) {
        localIdentical++;
        i++;
      }
      if (localIdentical > 0) {
        totalIdentical += (localIdentical * (localIdentical - 1)) / 2;
        localIdentical = 1;
      }
    }
    return totalIdentical;
  }

  @Test
  public void case1() {
    Assert.assertEquals(4, numIdenticalPairs(new int[]{1, 2, 3, 1, 1, 3}));
  }

  @Test
  public void case2() {
    Assert.assertEquals(6, numIdenticalPairs(new int[]{1, 1, 1, 1}));
  }

  @Test
  public void case3() {
    Assert.assertEquals(0, numIdenticalPairs(new int[]{1, 2, 3}));
  }

}
