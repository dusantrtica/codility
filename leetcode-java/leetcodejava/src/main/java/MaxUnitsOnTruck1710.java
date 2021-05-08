import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class MaxUnitsOnTruck1710 {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (a, b) -> Integer.compare(b[1], a[1]));
        int totalUnits = 0;
        int totalBoxes = 0;
        int i = 0;
        while (totalBoxes < truckSize && i < boxTypes.length) {
            int boxCount = boxTypes[i][0];
            int unitCount = boxTypes[i][1];
            if (boxCount + totalBoxes > truckSize) {
                boxCount = truckSize - totalBoxes;
            }
            totalBoxes += boxCount;
            totalUnits += boxCount * unitCount;
            i++;
        }
        return totalUnits;
    }

    @Test
    public void case1() {
        int[][] input = {{1, 3}, {2, 2}, {3, 1}};
        int truckSize = 4;
        Assert.assertEquals(8, maximumUnits(input, truckSize));
    }

    @Test
    public void case2() {
        int[][] input = {{5, 10}, {2, 5}, {4, 7}, {3, 9}};
        int truckSize = 10;
        Assert.assertEquals(91, maximumUnits(input, truckSize));
    }

    @Test
    public void case3() {
        int [][] input = {{4,3}};
        int truckSize = 3;
        Assert.assertEquals(9, maximumUnits(input, truckSize));
    }

    @Test
    public void case4() {
        int [][] input = {{1,3},{5,5},{2,5},{4,2},{4,1},{3,1},{2,2},{1,3},{2,5},{3,2}};
        int truckSize = 35;
        Assert.assertEquals(76, maximumUnits(input, truckSize));
    }
}

