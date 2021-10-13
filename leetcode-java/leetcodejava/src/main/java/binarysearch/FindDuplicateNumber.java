package binarysearch;

import org.junit.Assert;
import org.junit.Test;

public class FindDuplicateNumber {

  public int findDuplicate(int[] nums) {
    int tortoise = nums[0];
    int hare = nums[0];
    do {
      tortoise = nums[tortoise];
      hare = nums[nums[hare]];
    } while(tortoise != hare);

    tortoise = nums[0];
    while(tortoise != hare) {
      tortoise = nums[tortoise];
      hare = nums[hare];
    }

    return hare;
  }

  @Test
  public void case1() {
    Assert.assertEquals(2, findDuplicate(new int[]{1, 3, 4, 2, 2}));
  }

  @Test
  public void case2() {
    Assert.assertEquals(3, findDuplicate(new int[]{3, 1, 3, 4, 2}));
  }

  @Test
  public void case3() {
    Assert.assertEquals(1, findDuplicate(new int[]{1, 1, 2}));
  }

  @Test
  public void case4() {
    Assert.assertEquals(1, findDuplicate(new int[]{1, 1}));
  }
}
