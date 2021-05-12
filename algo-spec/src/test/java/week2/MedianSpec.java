package week2;

import c2.Median;
import org.junit.Assert;
import org.junit.Test;

public class MedianSpec {
    @Test
    public void singleElement() {
        Median m = new Median();
        m.insert(3);
        Assert.assertEquals(3, m.median());
    }

    @Test
    public void multipleElements() {
        Median m = new Median();
        m.insert(3);
        m.insert(4);
        m.insert(1);
        m.insert(2);
        m.insert(6);
        m.insert(5);

        Assert.assertEquals(4, m.median());
        Assert.assertEquals(3, m.median());
        Assert.assertEquals(5, m.median());
        Assert.assertEquals(2, m.median());
        Assert.assertEquals(6, m.median());
        Assert.assertEquals(1, m.median());
    }
}
