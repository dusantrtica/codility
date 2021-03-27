import org.junit.Assert;
import org.junit.Test;

public class DiagonalTraverse {
    public int[] findDiagonalOrder(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[] result = new int[m * n];
        int k = 0;
        int r = Math.min(m, n);
        for (int i = 0; i < m + n + 1; i++) {
            boolean flip = i % 2 == 1;
            for (int j = 0; j <= Math.min(r, i); j++) {
                int row = i - j;
                int col = j;

                if (flip) {
                    row = row < n ? row : n - 1;
                    col = col < m ? col : m - 1;
                    result[k] = matrix[col][row];
                } else {
                    row = row < m ? row : m - 1;
                    col = col < n ? col : n - 1;
                    result[k] = matrix[row][col];
                }
                k++;
            }
        }
        return result;
    }

    @Test
    public void case1() {
        int[] expected = {1, 2, 4, 5, 3, 6};
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}};
        Assert.assertArrayEquals(expected, findDiagonalOrder(matrix));
    }
}
