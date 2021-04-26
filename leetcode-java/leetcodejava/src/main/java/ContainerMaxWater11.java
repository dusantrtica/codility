import org.junit.Assert;
import org.junit.Test;

public class ContainerMaxWater11 {

  public int maxArea(int[] height) {
    int n = height.length;
    int i = 0;
    int j = n - 1;
    int maxArea = Math.min(height[i], height[j]) * (j - i);
    while(i < j) {
      int area = Math.min(height[i], height[j]) * (j - i);
      if(area > maxArea) {
        maxArea = area;
      }

      if(height[i] < height[j]) {
        i++;
      } else {
        j--;
      }
    }
    return maxArea;
  }

  @Test
  public void case1() {
    Assert.assertEquals(49, maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
  }

  @Test
  public void case2() {
    Assert.assertEquals(1, maxArea(new int[]{1, 1}));
  }

  @Test
  public void case3() {
    Assert.assertEquals(16, maxArea(new int[]{4, 3, 2, 1, 4}));
  }

  @Test
  public void case4() {
    Assert.assertEquals(2, maxArea(new int[]{1, 2, 1}));
  }

}
