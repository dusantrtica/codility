package arrays101;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

public class SortArrayByParity {
    public void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }

    public int[] sortArrayByParity(int[] A) {
        int len = A.length;
        int i = 0;
        int j = len - 1;

        while (i < j) {
            while (i < len && A[i] % 2 == 0) {
                i++;
            }

            while (j >= 0 && A[j] % 2 == 1) {
                j--;
            }

            if (i < j) {
                swap(A, i, j);
                i++;
                j--;
            }
        }
        return A;
    }

    @Test
    public void sample1() {
        int[] A = { 3, 1, 2, 4 };
        int[] expected = { 4, 2, 1, 3 };
        sortArrayByParity(A);
        assertArrayEquals(expected, A);
    }
}
