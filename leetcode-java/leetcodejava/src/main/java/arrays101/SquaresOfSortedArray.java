package arrays101;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

public class SquaresOfSortedArray {
    public int[] sortedSquares(int[] nums) {
        int len = nums.length;
        int[] result = new int[len];

        int startIndex = 0;
        int absMin = Math.abs(nums[0]);
        for (int i = 0; i < len; i++) {
            if (Math.abs(nums[i]) < absMin) {
                startIndex = i;
                absMin = Math.abs(nums[i]);
            }
        }

        int left = startIndex;
        int right = startIndex + 1;
        int i = 0;
        while (left >= 0 && right < len) {
            if (Math.abs(nums[left]) < Math.abs(nums[right])) {
                result[i] = nums[left] * nums[left];
                left--;
            } else {
                result[i] = nums[right] * nums[right];
                right++;
            }
            i++;
        }

        while (left >= 0) {
            result[i] = nums[left] * nums[left];
            left--;
            i++;
        }

        while (right < len) {
            result[i] = nums[right] * nums[right];
            right++;
            i++;
        }
        return result;
    }

    @Test
    public void sample1() {
        int[] nums = { -4, -1, 0, 3, 10 };
        int[] result = { 0, 1, 9, 16, 100 };
        assertArrayEquals(sortedSquares(nums), result);
    }

    @Test
    public void sample2() {
        int[] nums = { 1, 2, 3, 4, 5 };
        int[] result = { 1, 4, 9, 16, 25 };
        assertArrayEquals(sortedSquares(nums), result);
    }

    @Test
    public void sample3() {
        int[] nums = { -5, -4, -3, -2, -1 };
        int[] result = { 1, 4, 9, 16, 25 };
        assertArrayEquals(sortedSquares(nums), result);
    }
}
