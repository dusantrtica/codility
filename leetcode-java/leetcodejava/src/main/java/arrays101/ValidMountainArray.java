package arrays101;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ValidMountainArray {
    final int START = 0;
    final int UPSTREAM = 1;
    final int DOWNSTREAM = 2;

    public boolean validMountainArray(int[] arr) {
        int len = arr.length;
        int move = START;
        int i;
        for (i = 1; i < len; i++) {
            if (arr[i - 1] == arr[i]) {
                return false;
            }
            if (arr[i - 1] > arr[i]) {
                if (move == UPSTREAM) {
                    move = DOWNSTREAM;
                } else if (move == START) {
                    return false;
                }
            } else {
                if (move == DOWNSTREAM) {
                    return false;
                }
                move = UPSTREAM;
            }
        }

        return i == len && move == DOWNSTREAM;
    }

    // public boolean validMountainArray(int[] arr) {
    // int len = arr.length;
    // int i = 0;
    // while (i + 1 < len && arr[i] < arr[i + 1]) {
    // i++;
    // }

    // if (i == 0 || i == len - 1) {
    // return false;
    // }

    // while (i + 1 < len && arr[i] > arr[i + 1]) {
    // i++;
    // }
    // return i == len - 1;
    // }

    @Test
    public void sample1() {
        int[] arr = { 0, 3, 2, 1 };
        assertEquals(validMountainArray(arr), true);
    }

    @Test
    public void sample2() {
        int[] arr = { 1, 2, 3 };
        assertEquals(validMountainArray(arr), false);
    }

    @Test
    public void sample3() {
        int[] arr = { 1, 2, 3, 3, 2, 1 };
        assertEquals(validMountainArray(arr), false);
    }

    @Test
    public void sample4() {
        int[] arr = { 2, 1 };
        assertEquals(validMountainArray(arr), false);
    }

    @Test
    public void sample5() {
        int[] arr = { 3, 5, 5 };
        assertEquals(validMountainArray(arr), false);
    }

    @Test
    public void sample6() {
        int[] arr = { 1, 2, 3, 1 };
        assertEquals(validMountainArray(arr), true);
    }

    @Test
    public void sample7() {
        int[] arr = { 1, 2, 3, 1, 0, 2 };
        assertEquals(validMountainArray(arr), false);
    }

    @Test
    public void sample8() {
        int arr[] = { 2, 1, 2, 3, 5, 7, 9, 10, 12, 14, 15, 16, 18, 14, 13 };
        assertEquals(validMountainArray(arr), false);
    }
}
