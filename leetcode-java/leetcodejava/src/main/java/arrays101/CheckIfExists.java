package arrays101;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class CheckIfExists {
    public boolean checkIfExist(int[] arr) {

        Map<Integer, Boolean> values = new HashMap<>();
        for (int n : arr) {
            if (values.containsKey(n * 2) || (n % 2 == 0 && values.containsKey(n / 2))) {
                return true;
            }
            values.put(n, true);
        }

        return false;
    }

    @Test
    public void sample1() {
        int[] arr = {};
        assertEquals(checkIfExist(arr), false);
    }

    @Test
    public void sample2() {
        int[] arr = { 3 };
        assertEquals(checkIfExist(arr), false);
    }

    @Test
    public void sample3() {
        int[] arr = { 3, 5, 6 };
        assertEquals(checkIfExist(arr), true);
    }

    @Test
    public void sample4() {
        int[] arr = { 7, 11, 14, 1, 3 };
        assertEquals(checkIfExist(arr), true);
    }

    @Test
    public void sample5() {
        int[] arr = { 2, 3, 5, 7, 9, 11, 13 };
        assertEquals(checkIfExist(arr), false);
    }

    @Test
    public void important1() {
        int[] arr = { -2, 0, 10, -19, 4, 6, -8 };
        assertEquals(checkIfExist(arr), false);
    }

    @Test
    public void important2() {
        int[] arr = { 0, 0 };
        assertEquals(checkIfExist(arr), true);
    }
}
