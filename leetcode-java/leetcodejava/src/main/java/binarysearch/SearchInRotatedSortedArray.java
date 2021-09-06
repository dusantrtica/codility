package binarysearch;

import org.junit.Assert;
import org.junit.Test;

public class SearchInRotatedSortedArray {
    public int search(int[] nums, int target) {
        int len = nums.length;
        int start = 0;
        int end = len - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            int startElem = nums[start];
            int endElem = nums[end];
            int midElem = nums[mid];
            if (target == midElem) {
                return mid;
            }

            if (startElem <= midElem) {
                if (startElem <= target && target < midElem) {
                    end = mid - 1;
                } else {
                  start = mid + 1;
                }
            } else {
              if(midElem < target && target <= endElem) {
                start = mid + 1;
              } else {
                end = mid - 1;
              }
            }
        }
        return -1;
    }

    @Test
    public void case1() {
        Assert.assertEquals(3, search(new int[]{4, 5, 6, 0, 1, 2}, 0));
    }

    @Test
    public void case2() {
        Assert.assertEquals(-1, search(new int[]{4, 5, 6, 0, 1, 2}, 3));
    }

    @Test
    public void case3() {
        Assert.assertEquals(-1, search(new int[]{1}, 0));
    }

    @Test
    public void case4() {
        Assert.assertEquals(4, search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0));
    }

    @Test
    public void case5() {
        Assert.assertEquals(0, search(new int[]{3, 5, 1}, 3));
    }

    @Test
    public void case6() {
        Assert.assertEquals(4, search(new int[]{4, 5, 6, 7, 8, 1, 2, 3}, 8));
    }

    @Test
    public void case7() {
      Assert.assertEquals(1, search(new int [] {3, 1}, 1));
    }
}
