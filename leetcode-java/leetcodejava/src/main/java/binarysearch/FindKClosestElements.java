package binarysearch;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;

public class FindKClosestElements {

  public int binSearch(int[] arr, int x) {
    int n = arr.length;
    int start = 0;
    int end = n - 1;

    while (start <= end) {
      int mid = (start + end) / 2;
      if (arr[mid] == x) {
        return mid;
      } else if (arr[mid] < x) {
        start = mid + 1;
      } else {
        end = mid - 1;
      }
    }
    return start;
  }

  int findBetterIndex (int arr[], int left, int right, int val) {
    int n = arr.length;
    int leftDistance = left < 0 ? Integer.MAX_VALUE : Math.abs(arr[left] - val);
    int rightDistance = right >= n ? Integer.MAX_VALUE : Math.abs(arr[right] - val);

    return leftDistance <= rightDistance ? left : right;
  }

  public List<Integer> findClosestElements(int[] arr, int k, int x) {
    List<Integer> result = new ArrayList();
    int index = binSearch(arr, x);

    int left = index-1;
    int right = index;
    while (k-- > 0) {
      int indexToInsert = findBetterIndex(arr, left, right, x);
      if(indexToInsert == left) {
        result.add(0, arr[indexToInsert]);
        left--;
      } else {
        result.add(arr[indexToInsert]);
        right++;
      }
    }
    return result;
  }

  @Test
  public void case1() {
    Assert.assertEquals(2, binSearch(new int[]{1, 2, 3, 4, 5}, 3));
  }

  @Test
  public void case2() {
    Assert.assertEquals(0, binSearch(new int[]{1, 2, 3, 4, 5}, -3));
  }

  @Test
  public void case3() {
    Assert.assertEquals(3, binSearch(new int[]{1, 2, 3, 6, 7}, 4));
  }

  @Test
  public void case4() {
    Assert.assertEquals(4, binSearch(new int[]{1, 2, 3, 4, 5}, 10));
  }

  @Test
  public void case5() {
    Assert.assertEquals(0, binSearch(new int []{1,3}, 2));
  }
}
