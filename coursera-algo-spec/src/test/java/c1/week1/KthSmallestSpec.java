package c1.week1;

import org.junit.Assert;
import org.junit.Test;

public class KthSmallestSpec {
    KthSmallest task = new KthSmallest();

    @Test
    public void case1() {
        Assert.assertEquals(2, task.kSmallest(new int []{4,2,1,3}, 0, 3, 2));
    }

    @Test
    public void case2() {
        Assert.assertEquals(1, task.kSmallest(new int []{4,2,1,3,6,5,0}, 0, 6, 2));
    }

    @Test
    public void case3() {
        Assert.assertEquals(3, task.kSmallest(new int []{1,2,3,4,5,6,7,8}, 0, 7, 3));
    }

    @Test
    public void case4() {
        Assert.assertEquals(2, task.kSmallest(new int []{3,2,1,5,6,4}, 0, 5, 2));
    }
}
