package c1.week1;

public class MergeSort {

  private void merge(int[] a, int[] l, int[] r, int left, int right) {
    int k = 0;
    int i = 0, j = 0;
    while (i < left && j < right) {
      if (l[i] <= r[j]) {
        a[k++] = l[i++];
      } else {
        a[k++] = r[j++];
      }
    }

    while (i < left) {
      a[k++] = l[i++];
    }
    while (j < right) {
      a[k++] = r[j++];
    }
  }

  public void sort(int[] nums, int n) {
    if (n < 2) {
      return;
    }

    int mid = n / 2;
    int[] l = new int[mid];
    int[] r = new int[n - mid];

    for (int i = 0; i < mid; i++) {
      l[i] = nums[i];
    }

    for (int i = mid; i < n; i++) {
      r[i - mid] = nums[i];
    }

    sort(l, mid);
    sort(r, n - mid);

    merge(nums, l, r, mid, n - mid);
  }
}
