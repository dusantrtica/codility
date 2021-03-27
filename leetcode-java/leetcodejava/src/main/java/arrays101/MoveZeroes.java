package arrays101;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

public class MoveZeroes {
    public void moveZeroes(int[] nums) {
        int i = 0;
        int len = nums.length;
        for (int j = 0; j < len; j++) {
            if (nums[j] != 0) {
                nums[i] = nums[j];
                i++;
            }
        }

        for (; i < len; i++) {
            nums[i] = 0;
        }
    }

    @Test
    public void important1() {
        int[] nums = { 0, 1, 0, 3, 12 };
        int[] expected = { 1, 3, 12, 0, 0 };

        moveZeroes(nums);
        assertArrayEquals(nums, expected);
    }
}
