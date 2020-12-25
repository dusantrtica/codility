package arrays101;

import static org.junit.Assert.assertArrayEquals;

import java.util.Arrays;

import org.junit.Test;

public class DuplicateZeroes {

    public void duplicateZeroes(int[] array) {
        int zeroesCount = (int) Arrays.stream(array).filter(e -> e == 0).count();
        if (zeroesCount == 0) {
            return;
        }

        int len = array.length;
        int i = len - 1;
        int j = len - 1;

        for (i = len - 1, j = len + zeroesCount - 1; i >= 0; i--, j--) {
            if (array[i] == 0) {
                if (j < len) {
                    array[j] = array[i];
                }
                j--;
                if (j < len) {
                    array[j] = array[i];
                }
            } else {
                if (j < len) {
                    array[j] = array[i];
                }
            }
        }

    }

    @Test
    public void simple1() {
        int[] input = { 1 };
        duplicateZeroes(input);
        int[] output = { 1 };
        assertArrayEquals(input, output);
    }

    @Test
    public void basic1() {
        int[] input = { 0, 1 };
        duplicateZeroes(input);
        int[] output = { 0, 0 };
        assertArrayEquals(input, output);
    }

    @Test
    public void basic2() {
        int[] input = { 1, 0 };
        duplicateZeroes(input);
        int[] output = { 1, 0 };
        assertArrayEquals(input, output);
    }

    @Test
    public void important1() {
        int[] input = { 1, 0, 2, 3, 0, 4, 5, 0 };
        duplicateZeroes(input);
        int[] output = { 1, 0, 0, 2, 3, 0, 0, 4 };
        assertArrayEquals(input, output);
    }

    @Test
    public void trivial1() {
        int[] input = {};
        int[] output = {};
        duplicateZeroes(input);
        assertArrayEquals(input, output);
    }

    @Test
    public void basic3() {
        int[] input = { 0, 1, 2 };
        int[] expected = { 0, 0, 1 };
        duplicateZeroes(input);
        assertArrayEquals(input, expected);
    }

    @Test
    public void basic4() {
        int[] input = { 0, 0, 1, 2 };
        int[] expected = { 0, 0, 0, 0 };
        duplicateZeroes(input);
        assertArrayEquals(expected, input);
    }

    @Test
    public void important2() {
        int[] input = { 0, 1, 0, 2, 0, 3 };
        int[] expected = { 0, 0, 1, 0, 0, 2 };
        duplicateZeroes(input);
        assertArrayEquals(expected, input);
    }

    @Test
    public void important3() {
        int[] input = { 8, 4, 5, 0, 0, 0, 0, 7 };
        int[] expected = { 8, 4, 5, 0, 0, 0, 0, 0 };
        duplicateZeroes(input);
        assertArrayEquals(expected, input);
    }

    @Test
    public void basic5() {
        int[] input = { 1, 0, 0, 1 };
        int[] expected = { 1, 0, 0, 0 };
        duplicateZeroes(input);
        assertArrayEquals(expected, input);
    }

}
