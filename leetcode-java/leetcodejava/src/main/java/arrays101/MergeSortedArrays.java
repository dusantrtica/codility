package arrays101;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

public class MergeSortedArrays {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;
        int k = nums1.length - 1;

        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                nums1[k] = nums1[i];
                i--;
            } else {
                nums1[k] = nums2[j];
                j--;
            }
            k--;
        }

        if (i >= 0) {
            while (i >= 0) {
                nums1[k] = nums1[i];
                i--;
                k--;
            }
        }

        if (j >= 0) {
            while (j >= 0) {
                nums1[k] = nums2[j];
                j--;
                k--;
            }
        }
    }

    @Test
    public void trivial1() {
        int[] nums1 = {};
        int[] nums2 = {};
        int m = 0;
        int n = 0;
        int[] expected = {};
        merge(nums1, m, nums2, n);
        assertArrayEquals(nums1, expected);
    }

    @Test
    public void trivial2() {
        int[] nums1 = { 0 };
        int[] nums2 = { 1 };
        int m = 0;
        int n = 1;
        int[] expected = { 1 };
        merge(nums1, m, nums2, n);
        assertArrayEquals(nums1, expected);
    }

    @Test
    public void trivial3() {
        int[] nums1 = { 1 };
        int[] nums2 = {};
        int m = 1;
        int n = 0;
        int[] expected = { 1 };
        merge(nums1, m, nums2, n);
        assertArrayEquals(nums1, expected);
    }

    @Test
    public void basic1() {
        int[] nums1 = { 1, 2, 0 };
        int[] nums2 = { 3 };
        int m = 2;
        int n = 1;
        int[] expected = { 1, 2, 3 };
        merge(nums1, m, nums2, n);
        assertArrayEquals(nums1, expected);
    }

    @Test
    public void basic2() {
        int[] nums1 = { 1, 0, 0 };
        int[] nums2 = { 2, 3 };
        int m = 1;
        int n = 2;
        int[] expected = { 1, 2, 3 };
        merge(nums1, m, nums2, n);
        assertArrayEquals(nums1, expected);
    }

    @Test
    public void basic3() {
        int[] nums1 = { 0, 0 };
        int[] nums2 = { 2, 3 };
        int m = 0;
        int n = 2;
        int[] expected = { 2, 3 };
        merge(nums1, m, nums2, n);
        assertArrayEquals(nums1, expected);
    }

    @Test
    public void important1() {
        int[] nums1 = { 1, 3, 5, 0, 0 };
        int[] nums2 = { 2, 4 };
        int m = 3;
        int n = 2;
        int[] expected = { 1, 2, 3, 4, 5 };
        merge(nums1, m, nums2, n);
        assertArrayEquals(nums1, expected);
    }

    @Test
    public void important2() {
        int[] nums1 = { 1, 2, 3, 0, 0, 0 };
        int[] nums2 = { 2, 5, 6 };
        int m = 3;
        int n = 3;
        int[] expected = { 1, 2, 2, 3, 5, 6 };
        merge(nums1, m, nums2, n);
        assertArrayEquals(nums1, expected);
    }
}
