import org.junit.Assert;
import org.junit.Test;

public class Stock121 {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if (n <= 1) {
            return 0;
        }

        int maxProfit = 0;

        int minPrice = prices[0];
        for(int i = 0; i < n; i++) {
            if(prices[i] < minPrice) {
                minPrice = prices[i];
            } else {
                maxProfit = Math.max(prices[i] - minPrice, maxProfit);
            }
        }

        return maxProfit;
    }

    @Test
    public void case1() {
        Assert.assertEquals(5, maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
    }

    @Test
    public void case2() {
        Assert.assertEquals(0, maxProfit(new int[]{7, 6, 4, 3, 1}));
    }

    @Test
    public void case3() {
        Assert.assertEquals(0, maxProfit(new int[]{6, 5, 4, 3, 1}));
    }

    @Test
    public void case4() {
        Assert.assertEquals(4, maxProfit(new int[]{10, 7, 11, 6, 8}));
    }
}
