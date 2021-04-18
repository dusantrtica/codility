package c1.week1;

import org.junit.Assert;
import org.junit.Test;

public class QuickSortSpec {
    QuickSort qc = new QuickSort();

    @Test
    public void case1() {
        int [] array = {3,8,2,5,1,4,7,6};
        qc.quicksort(array, 0, array.length-1);
        Assert.assertArrayEquals(new int[]{1, 2, 3, 4, 5, 6, 7, 8},array);
    }
}
