package binarysearch;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

public class SearchForRange {

  public int binSearch(int [] nums, int target, boolean isFirst) {
    final int n = nums.length;
    int start = 0;
    int end = n-1;

    while(start <= end) {
      int mid = (start + end)/2;
      int midElem = nums[mid];
      if(midElem == target) {
        if((mid == start || nums[mid-1] != target) && isFirst) {
          return mid;
        } else if ((mid == end || nums[mid+1] != target) && !isFirst) {
          return mid;
        } else if(isFirst) {
          end = mid-1;
        } else if(!isFirst) {
          start = mid+1;
        }
      } else if(midElem < target) {
        start = mid+1;
      } else {
        end = mid-1;
      }
    }
    return -1;
  }

  public int[] searchRange(int[] nums, int target) {
   int first = binSearch(nums, target, true);
   if(first == -1) {
     return new int []{-1, -1};
   }
   int last = binSearch(nums, target, false);
   return new int []{first, last};
  }

  @Test
  public void case1() {
    assertArrayEquals(new int[]{3, 4}, searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8));
  }

  @Test
  public void case1_1() {
    assertArrayEquals(new int[]{0, 0}, searchRange(new int[]{5, 7, 7, 8, 8, 10}, 5));
  }

  @Test
  public void case1_2() {
    assertArrayEquals(new int[]{5, 5}, searchRange(new int[]{5, 7, 7, 8, 8, 10}, 10));
  }

  @Test
  public void case1_3() {
    assertArrayEquals(new int[]{1, 2}, searchRange(new int[]{5, 7, 7, 8, 8, 10}, 7));
  }

  @Test
  public void case2() {
    assertArrayEquals(new int[]{-1, -1}, searchRange(new int[]{5, 7, 7, 8, 8, 10}, 6));
  }

  @Test
  public void case3() {
    assertArrayEquals(new int[]{-1, -1}, searchRange(new int[]{}, 0));
  }

  @Test
  public void case4() {
    assertArrayEquals(new int[]{0, 0}, searchRange(new int[]{1}, 1));
  }

  @Test
  public void case5() {
    assertArrayEquals(new int[]{-1, -1}, searchRange(new int[]{2, 2}, 1));
  }

  @Test
  public void case6() {
    assertArrayEquals(new int[]{0, 1}, searchRange(new int[]{2, 2}, 2));
  }
}
