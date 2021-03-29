import java.util.ArrayList;
import java.util.List;

class SpiralMatrix {

    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int mn = m * n;
        List<Integer> result = new ArrayList<>(mn);
        if (mn == 0) {
            return result;
        }

        int i, k = 0, l = 0;

        /*  k - starting row index
        m - ending row index
        l - starting column index
        n - ending column index
        i - iterator
        */

        while (k < m && l < n) {
            // Print the first row from the remaining rows
            for (i = l; i < n; ++i) {
                result.add(matrix[k][i]);
            }
            k++;

            // Print the last column from the remaining
            // columns
            for (i = k; i < m; ++i) {
               result.add(matrix[i][n - 1]);
            }
            n--;

            // Print the last row from the remaining rows */
            if (k < m) {
                for (i = n - 1; i >= l; --i) {
                    result.add(matrix[m - 1][i]);
                }
                m--;
            }

            // Print the first column from the remaining
            // columns */
            if (l < n) {
                for (i = m - 1; i >= k; --i) {
                    result.add(matrix[i][l]);
                }
                l++;
            }
        }

        return result;
    }
}