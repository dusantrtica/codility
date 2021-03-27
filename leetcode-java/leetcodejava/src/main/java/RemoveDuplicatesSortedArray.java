import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

public class RemoveDuplicatesSortedArray {

  public static void main(String[] args) {
  }

  public int removeDuplicates(int[] nums) {
    int j = 1;
    int n = nums.length;

    for(int i = 1; i < n; i++) {
      if(nums[i-1] < nums[i]) {
        nums[j++] = nums[i];
      }
    }
    return j;
  }

  private int[] trimArray(int[] nums, int size) {
    int[] newArray = new int[size];
    for (int i = 0; i < size; i++) {
      newArray[i] = nums[i];
    }

    return newArray;
  }

  @Test
  public void sample1() {
    int[] nums = {1, 1, 2};
    int size = removeDuplicates(nums);
    int[] expected = {1, 2};
    assertArrayEquals(expected, trimArray(nums, size));
  }

  @Test
  public void sample2() {
    int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
    int size = removeDuplicates(nums);
    int[] expected = {0, 1, 2, 3, 4};
    assertArrayEquals(expected, trimArray(nums, size));
  }
}
