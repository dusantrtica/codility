import org.junit.Assert;
import org.junit.Test;

public class NUniqueIntegersSumToZero1304 {

  public int[] sumZero(int n) {
    int[] result = new int[n];
    int index = 0;
    if (n % 2 == 1) {
      result[index++] = 0;
      n--;
    }
    for (int i = 1; i <= n/2; i++) {
      result[index++] = i;
      result[index++] = -i;
    }

    return result;
  }

  @Test
  public void case1() {
    Assert.assertArrayEquals(new int[]{0, 1, -1, 2, -2}, sumZero(5));
  }

  @Test
  public void case2() {
    Assert.assertArrayEquals(new int []{1, -1, 2, -2}, sumZero(4));
  }

  @Test
  public void case3() {
    Assert.assertArrayEquals(new int []{0}, sumZero(1));
  }
}
