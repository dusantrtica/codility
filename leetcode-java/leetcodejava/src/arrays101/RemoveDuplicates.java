package arrays101;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;

public class RemoveDuplicates {
    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public int removeDuplicates(int[] nums) {
        int len = nums.length;
        if (len == 0 || len == 1) {
            return len;
        }

        int i = 0;
        for (int j = 1; j < len; j++) {
            if (nums[i] != nums[j]) {
                i++;
                nums[i] = nums[j];
            }
        }

        return i + 1;

    }

    public int removeDuplicates_(int[] nums) {
        int len = nums.length;
        if (len == 0 || len == 1) {
            return len;
        }

        int i = 0;
        int j = 0;

        while (j < len) {
            j = i + 1;
            while (i < len && j < len && nums[i] < nums[j]) {
                i++;
                j++;
            }
            if (j < len) {
                while (j < len && !(nums[i] < nums[j])) {
                    j++;
                }
                if (j < len) {
                    i++;
                    swap(nums, i, j);
                } else {
                    break;
                }
            }
        }
        return i + 1;
    }

    @Test
    public void case1() {
        int[] nums = {};
        int newLen = removeDuplicates(nums);
        int[] expected = {};
        assertEquals(newLen, 0);
        assertArrayEquals(expected, Arrays.copyOfRange(nums, 0, newLen));
    }

    @Test
    public void case2() {
        int[] nums = { 1, 2, 3 };
        int newLen = removeDuplicates(nums);
        int[] expected = { 1, 2, 3 };
        assertEquals(newLen, 3);
        assertArrayEquals(expected, Arrays.copyOfRange(nums, 0, newLen));
    }

    @Test
    public void case3() {
        int[] nums = { 1, 1, 2, 2, 3 };
        int newLen = removeDuplicates(nums);
        int[] expected = { 1, 2, 3 };
        assertEquals(newLen, 3);
        assertArrayEquals(expected, Arrays.copyOfRange(nums, 0, newLen));
    }

    @Test
    public void case4() {
        int[] nums = { 1, 1, 1 };
        int newLen = removeDuplicates(nums);
        int[] expected = { 1 };
        assertEquals(newLen, 1);
        assertArrayEquals(expected, Arrays.copyOfRange(nums, 0, newLen));
    }

    @Test
    public void case5() {
        int[] nums = { 1, 1, 2 };
        int newLen = removeDuplicates(nums);
        int[] expected = { 1, 2 };
        assertEquals(newLen, 2);
        assertArrayEquals(expected, Arrays.copyOfRange(nums, 0, newLen));
    }

    @Test
    public void case6() {
        int[] nums = { 0, 0, 1, 1, 1, 2, 2, 3, 3, 4 };
        int newLen = removeDuplicates(nums);
        int[] expected = { 0, 1, 2, 3, 4 };
        assertEquals(newLen, 5);
        assertArrayEquals(expected, Arrays.copyOfRange(nums, 0, newLen));
    }

}
