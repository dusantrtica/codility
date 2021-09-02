import org.junit.Assert;
import org.junit.Test;

public class MaxConsecutiveOnesII487 {

  public int findMaxConsecutiveOnes(int [] nums){
    int n = nums.length;
    if(n <= 1) {
      return n;
    }

    int maxLen = 0;
    int currLen = 0;

    int begin = 0;
    int end = 0;
    int zeroesCnt = 0;

    while(end < n) {
      if(nums[end] == 0) {
        zeroesCnt++;
      }
      if(zeroesCnt == 2) {
        while(zeroesCnt == 2) {
          if(nums[begin] == 0) {
            zeroesCnt--;
          }
          begin ++;
        }
      }
      maxLen = Math.max(maxLen, end - begin + 1);
      end++;
    }
    return maxLen;
  }

  @Test
  public void case1() {
    Assert.assertEquals(4, findMaxConsecutiveOnes(new int [] {1,0,1,1,0}));
  }

  @Test
  public void case2() {
    Assert.assertEquals(4, findMaxConsecutiveOnes(new int []{1,0,1,1,0,1}));
  }

  @Test
  public void case3() {
    Assert.assertEquals(5, findMaxConsecutiveOnes(new int []{1,0,1,1,0,1, 1}));
  }

  @Test
  public void case4() {
    Assert.assertEquals(1, findMaxConsecutiveOnes(new int [] {0}));
  }

  @Test
  public void case5() {
    Assert.assertEquals(5, findMaxConsecutiveOnes(new int []{1,1,1,1,1}));
  }
}
