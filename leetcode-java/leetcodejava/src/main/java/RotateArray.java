public class RotateArray {

  // public void reverse(int[] nums, int start, int end) {
  // for (int i = start, j = end; i < j; i++, j--) {
  // int temp = nums[i];
  // nums[i] = nums[j];
  // nums[j] = temp;
  // }
  // }

  // public void rotate(int[] nums, int k) {
  // int n = nums.length;
  // k = k % n;
  // if (k == 0 || n == 0 || n == 1) {
  // return;
  // }

  public static void main(String[] args) {
    int[] nums = {1, 2, 3, 4};
    int k = 2;

    RotateArray r = new RotateArray();
    r.rotate(nums, k);
    for (int elem : nums) {
      System.out.print(elem);
      System.out.println(" ");

    }
  }

  // reverse(nums, 0, n - 1);
  // reverse(nums, 0, k - 1);
  // reverse(nums, k, n - 1);
  // }
  public void rotate(int[] nums, int k) {
    int n = nums.length;

    k = k % n;

    if (k == 0 || n == 0 || n == 1) {
      return;
    }

    int count = 0;
    for (int start = 0; count < n; start++) {
      int currIdx = start;
      int currVal = nums[currIdx];
      do {
        int nextIdx = (currIdx + k) % n;
        int temp = nums[nextIdx];
        nums[nextIdx] = currVal;
        currVal = temp;
        currIdx = nextIdx;
        count++;
      } while (currIdx != start);
    }
  }
}
