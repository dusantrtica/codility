import org.junit.Assert;
import org.junit.Test;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PascalTriangleRow {
    private BigInteger fact(int n) {
        BigInteger p = BigInteger.valueOf(1);
        for (int i = 1; i <= n; i++) {
            p = p.multiply(BigInteger.valueOf(i));

        }

        return p;
    }

    public List<Integer> getRow(int rowIndex) {
        List<Integer> result = new ArrayList<>(rowIndex + 1);
        result.add(1);

        BigInteger kFact = BigInteger.valueOf(1);
        BigInteger nFact = fact(rowIndex);

        for (int k = 1; k <= rowIndex; k++) {
            kFact = kFact.multiply(BigInteger.valueOf(k));

            BigInteger binomCoeff = nFact.divide(kFact.multiply(fact(rowIndex - k)));


            result.add(binomCoeff.intValue());
        }

        return result;
    }

    @Test
    public void case1() {
        List<Integer> result = getRow(0);
        Assert.assertEquals(result, Arrays.asList(1));
    }

    @Test
    public void case2() {
        List<Integer> result = getRow(1);
        Assert.assertEquals(result, Arrays.asList(1, 1));
    }

    @Test
    public void case3() {
        List<Integer> result = getRow(2);
        Assert.assertEquals(Arrays.asList(1, 2, 1), result);
    }

    @Test
    public void case4() {
        List<Integer> result = getRow(3);
        Assert.assertEquals(Arrays.asList(1, 3, 3, 1), result);
    }

    @Test
    public void case5() {
        List<Integer> result = getRow(4);
        Assert.assertEquals(Arrays.asList(1, 4, 6, 4, 1), result);
    }

    @Test
    public void case6() {
        List<Integer> result = getRow(5);
        Assert.assertEquals(Arrays.asList(1, 5, 10, 10, 5, 1), result);
    }

    @Test
    public void case7() {
        List<Integer> result = getRow(6);
        Assert.assertEquals(Arrays.asList(1, 6, 15, 20, 15, 6, 1), result);
    }

    @Test
    public void case8() {
        List<Integer> result = getRow(13);
        Assert.assertEquals(Arrays.asList(1, 13, 78, 286, 715, 1287, 1716, 1716, 1287, 715, 286, 78, 13, 1), result);
    }

    @Test
    public void case9() {
        List<Integer> result = getRow(21);
        Assert.assertEquals(Arrays.asList(1, 21, 210, 1330, 5985, 20349, 54264, 116280, 203490, 293930, 352716, 352716, 293930, 203490, 116280, 54264, 20349, 5985, 1330, 210, 21, 1), result);
    }
}
