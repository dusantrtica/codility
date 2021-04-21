import org.junit.Assert;
import org.junit.Test;

public class KthLargest215 {

  private void swap(int[] A, int i, int j) {
    int tmp = A[i];
    A[i] = A[j];
    A[j] = tmp;
  }

  private int partition(int[] A, int l, int r) {
    int p = A[l];
    int i = l + 1;
    for (int j = l + 1; j <= r; j++) {
      if (A[j] < p) {
        swap(A, i, j);
        i++;
      }
    }
    swap(A, l, i-1);
    return i-1;
  }

  public int kSmallest(int[] A, int low, int high, int k) {
    if(high == low) {
      return A[high];
    }

    int pivotIdx = partition(A, low, high);

    if(pivotIdx - low == k) {
      return A[pivotIdx];
    }

    if(pivotIdx - low > k) {
      return kSmallest(A, low, pivotIdx-1, k);
    }
    return kSmallest(A, pivotIdx+1, high, k-pivotIdx + low -  1);
  }

  public int findKthLargest(int[] nums, int k) {
    return kSmallest(nums, 0, nums.length - 1, nums.length - k);
  }

  @Test
  public void case1() {
    Assert.assertEquals(5, findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2));
  }

  @Test
  public void case2() {
    Assert.assertEquals(4, findKthLargest(new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6}, 4));
  }
}
