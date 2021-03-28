import org.junit.Assert;
import org.junit.Test;

public class DiagonalTraverse {
    public int[] findDiagonalOrder(int[][] matrix) {
        int n = matrix.length;
        if(n == 0) {
            return new int [0];
        }
        int m = matrix[0].length;
        int[] result = new int[m * n];
        int col = 0;
        int row = 0;
        int k = 0;
        int mn = m * n;

        if (m == 0 && n == 0) {
            return result;
        }

        boolean upwards = true;

        while (k < mn) {
            result[k] = matrix[row][col];
            k++;

            int newCol;
            int newRow;

            newCol = col + (upwards ? 1 : -1);
            newRow = row + (upwards ? -1 : 1);

            if (newRow < 0 || newCol < 0 || newRow == n || newCol == m) {
                if (upwards) {
                    row = (col == m - 1 ? row + 1 : row);
                    col = (col < m - 1 ? col + 1 : col);
                } else {
                    col = (row == n - 1 ? col + 1 : col);
                    row = (row < n - 1 ? row + 1 : row);
                }
                upwards = !upwards;
            } else {
                row = newRow;
                col = newCol;
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
