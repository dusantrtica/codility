package arrays101;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

public class ReplaceElemsWithGreatestOnRight {
    public int[] replaceElements(int[] arr) {
        int len = arr.length;
        if (len == 0) {
            return arr;
        }

        int max = -1;
        for (int i = len - 1; i >= 0; i--) {
            int curr = arr[i];
            arr[i] = max;
            max = max > curr ? max : curr;
        }
        return arr;

    }

    @Test
    public void sample1() {
        int[] arr = { 17, 18, 5, 4, 6, 1 };
        int[] actual = replaceElements(arr);
        int[] expected = { 18, 6, 6, 6, 1, -1 };
        assertArrayEquals(expected, actual);
    }

    @Test
    public void sample2() {
        int[] arr = { 7, 9, 1, 8, 2 };
        int[] actual = replaceElements(arr);
        int[] expected = { 9, 8, 8, 2, -1 };
        assertArrayEquals(expected, actual);
    }

    @Test
    public void trivial() {
        int[] arr = {};
        int[] actual = replaceElements(arr);
        int[] expected = {};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void trivia2() {
        int[] arr = { 3 };
        int[] actual = replaceElements(arr);
        int[] expected = { -1 };
        assertArrayEquals(expected, actual);
    }

    @Test
    public void sample3() {
        int[] arr = { 3, 2, 1 };
        int[] actual = replaceElements(arr);
        int[] expected = { 2, 1, -1 };
        assertArrayEquals(expected, actual);
    }

    @Test
    public void sample4() {
        int[] arr = { 1, 2, 3, 4, 5 };
        int[] actual = replaceElements(arr);
        int[] expected = { 5, 5, 5, 5, -1 };
        assertArrayEquals(expected, actual);
    }
}
