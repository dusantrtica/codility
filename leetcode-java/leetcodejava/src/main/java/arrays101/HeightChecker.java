package arrays101;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;

public class HeightChecker {
    public int heightChecker(int[] heights) {
        int len = heights.length;
        int[] copy = Arrays.copyOfRange(heights, 0, heights.length);
        Arrays.sort(heights);
        int numOfDifferences = 0;
        for (int i = 0; i < len; i++) {
            if (copy[i] != heights[i]) {
                numOfDifferences++;
            }
        }

        return numOfDifferences;
    }

    @Test
    public void sample1() {
        int[] heights = { 5, 1, 2, 3, 4 };
        int result = heightChecker(heights);
        assertEquals(result, 5);
    }

    @Test
    public void sample2() {
        int[] heights = { 1, 2, 3, 4, 5 };
        int result = heightChecker(heights);
        assertEquals(result, 0);
    }

    @Test
    public void sample3() {
        int[] heights = { 1, 1, 4, 2, 1, 3 };
        int result = heightChecker(heights);
        assertEquals(result, 3);
    }

}
