package arrays101;

import static org.junit.Assert.assertEquals;

import java.util.HashSet;

import org.junit.Test;

public class ThirdMaxNum {
    public int thirdMax(int[] nums) {
        int len = nums.length;

        HashSet<Integer> set = new HashSet<>();

        int max1 = nums[0];
        int max2 = Integer.MIN_VALUE;
        int max3 = Integer.MIN_VALUE;

        set.add(max1);

        for (int i = 1; i < len; i++) {
            if (set.size() < 3) {
                set.add(nums[i]);
            }

            int curr = nums[i];
            if (curr > max1) {
                max3 = max2;
                max2 = max1;
                max1 = curr;
            } else if (curr < max1 && curr > max2) {
                max3 = max2;
                max2 = curr;
            } else if (curr < max2 && curr > max3) {
                max3 = curr;
            }
        }

        if (set.size() == 3 && max1 != max2 && max2 != max3) {
            return max3;
        }

        return max1;
    }

    @Test
    public void sample1() {
        int[] nums = { 1, 2 };
        assertEquals(2, thirdMax(nums));
    }

    @Test
    public void sample2() {
        int[] nums = { 3, 2, 1 };
        assertEquals(1, thirdMax(nums));
    }

    @Test
    public void sample3() {
        int[] nums = { 2, 2, 3, 1 };
        assertEquals(1, thirdMax(nums));
    }
}
