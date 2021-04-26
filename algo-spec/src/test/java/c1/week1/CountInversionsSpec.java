package c1.week1;

import org.junit.Assert;
import org.junit.Test;

public class CountInversionsSpec {
    CountInversions count = new CountInversions();

    @Test
    public void sample1() {
        int[] nums = {5, 4, 3, 2, 1};
        Assert.assertEquals(10, count.countInversions(nums));
    }

    @Test
    public void sortedArray() {
        int[] nums = {1, 2, 3, 4, 5};
        Assert.assertEquals(0, count.countInversions(nums));
    }

    @Test
    public void randomArray() {
        int[] nums = {4, 5, 1, 2, 3};
        Assert.assertEquals(6, count.countInversions(nums));
    }

    @Test
    public void oneElementArray() {
        int[] nums = {1};
        Assert.assertEquals(0, count.countInversions(nums));
    }

    @Test
    public void basicTestWith4Elements() {
        int [] nums = {4,3, 1, 2};
        Assert.assertEquals(5, count.countInversions(nums));
    }
}
