package arrays101;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertArrayEquals;

import java.util.Arrays;

import org.junit.Test;

public class RemoveElement27 {
    void swap(int[] nums, int x, int y) {
        int temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;

    }

    public int removeElement(int[] nums, int val) {
        int len = nums.length;
        int i = 0;
        for (int j = 0; j < len; j++) {
            if (nums[j] != val) {
                nums[i] = nums[j];
                i++;
            }
        }
        return i;
    }

    public int removeElement_(int[] nums, int val) {
        int len = nums.length;
        int i = len - 1;
        int j = i;

        // Trivial cases covered and early exit:
        // Empty array and if val was found
        if (len == 0) {
            return len;
        }

        int countVal = (int) Arrays.stream(nums).filter(e -> e == val).count();

        if (countVal == 0) {
            return len;
        }

        while (j >= 0 && i >= 0) {
            while (i >= 0) {
                if (nums[i] == val) {
                    break;
                }
                i--;
            }

            while (j >= 0) {
                if (nums[j] != val) {
                    break;
                }
                j--;
            }

            if (i < 0 || j < 0) {
                break;
            }

            if (i < j) {
                swap(nums, i, j);

                i--;
                j--;
            } else {
                i--;
            }
        }
        return len - countVal;
    }

    @Test
    public void trivial1() {
        int[] nums = {};
        int val = 10;
        int newLen = removeElement(nums, val);

        assertEquals(newLen, 0);
        int[] expected = {};
        assertArrayEquals(nums, expected);
    }

    @Test
    public void basic1() {
        int[] nums = { 1 };
        int val = 1;
        int newLen = removeElement(nums, val);

        assertEquals(newLen, 0);
        int[] expected = {};
        assertArrayEquals(Arrays.copyOfRange(nums, 0, newLen), expected);
    }

    @Test
    public void important1() {
        int[] nums = { 3, 2, 2, 3 };
        int val = 3;
        int newLen = removeElement(nums, val);

        assertEquals(newLen, 2);
        int[] expected = { 2, 2 };

        assertArrayEquals(Arrays.copyOfRange(nums, 0, newLen), expected);
    }

    @Test
    public void important2() {
        int[] nums = { 0, 1, 2, 2, 3, 0, 4, 2 };
        int val = 3;
        int newLen = removeElement(nums, val);

        assertEquals(newLen, 7);
        int[] expected = { 0, 1, 2, 2, 0, 4, 2 };

        assertArrayEquals(Arrays.copyOfRange(nums, 0, newLen), expected);
    }

    @Test
    public void basic2() {
        int[] nums = { 1, 2, 2, 1 };
        int val = 2;
        int newLen = removeElement(nums, val);

        assertEquals(newLen, 2);
        int[] expected = { 1, 1 };
        assertArrayEquals(Arrays.copyOfRange(nums, 0, newLen), expected);
    }

    @Test
    public void basic3() {
        int[] nums = { 1, 2, 2, 1 };
        int val = 1;
        int newLen = removeElement(nums, val);

        assertEquals(newLen, 2);
        int[] expected = { 2, 2 };
        assertArrayEquals(Arrays.copyOfRange(nums, 0, newLen), expected);
    }

    @Test
    public void basic4() {
        int[] nums = { 1, 1 };
        int val = 1;
        int newLen = removeElement(nums, val);

        assertEquals(newLen, 0);
        int[] expected = {};
        assertArrayEquals(Arrays.copyOfRange(nums, 0, newLen), expected);
    }

    @Test
    public void trivial2() {
        int[] nums = { 1, 2, 2, 1 };
        int val = 3;
        int newLen = removeElement(nums, val);

        assertEquals(newLen, 4);
        int[] expected = { 1, 2, 2, 1 };
        assertArrayEquals(Arrays.copyOfRange(nums, 0, newLen), expected);
    }

    @Test
    public void basic5() {
        int[] nums = { 1, 2, 3, 4 };
        int val = 2;
        int newLen = removeElement(nums, val);

        assertEquals(newLen, 3);
        int[] expected = { 1, 3, 4 };
        assertArrayEquals(Arrays.copyOfRange(nums, 0, newLen), expected);
    }

}
