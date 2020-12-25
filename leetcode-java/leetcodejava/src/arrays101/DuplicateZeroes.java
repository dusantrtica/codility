package arrays101;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

public class DuplicateZeroes {

    public void duplicateZeroes(int[] array) {

    }

    @Test
    public void test1() {
        int[] input = { 1 };
        duplicateZeroes(input);
        int[] output = { 1 };
        assertArrayEquals(input, output);
    }

    @Test
    public void test2() {
        int[] input = { 0, 1 };
        duplicateZeroes(input);
        int[] output = { 0, 0 };
        assertArrayEquals(input, output);
    }

    @Test
    public void test3() {
        int[] input = { 1, 0, 2, 3, 0, 4, 5, 0 };
        duplicateZeroes(input);
        int[] output = { 1, 0, 0, 2, 3, 0, 0, 4 };
        assertArrayEquals(input, output);
    }
}
