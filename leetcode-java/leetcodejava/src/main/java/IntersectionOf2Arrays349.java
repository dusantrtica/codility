import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class IntersectionOf2Arrays349 {
  public int[] intersection(int[] nums1, int[] nums2) {
    Arrays.sort(nums1);
    Arrays.sort(nums2);
    int m = nums1.length;
    int n = nums2.length;
    if(m == 0 || n == 0) {
      return new int []{};
    }

    int [] result = new int[Math.min(m, n)];

    int i = 0;
    int j = 0;
    int k = 0;

    while(i < m && j < n) {
      if (nums1[i] < nums2[j]) {
        i++;
      } else if(nums1[i] > nums2[j]) {
        j++;
      } else {
        if(k == 0 || result[k-1] != nums1[i]) {
          result[k++] = nums1[i];
        }

        i++;
        j++;
      }

    }

    return Arrays.copyOf(result, k);
  }
}
