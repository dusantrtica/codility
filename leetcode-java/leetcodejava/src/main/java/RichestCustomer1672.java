public class RichestCustomer1672 {
    public int maximumWealth(int[][] accounts) {
        int m = accounts.length;
        int n = accounts[0].length;

        int maxSum = 0;
        for (int i = 0; i < m; i++) {
            int tempSum = 0;
            for (int j = 0; j < n; j++) {
                tempSum += accounts[i][j];
            }
            if (tempSum > maxSum) {
                maxSum = tempSum;
            }
        }
        return maxSum;
    }
}
