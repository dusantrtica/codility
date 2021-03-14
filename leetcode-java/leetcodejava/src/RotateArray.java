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

        int val = nums[0];
        int nextIdx = k;

        for (int i = 0; i < n; i++) {
            int tmpVal = nums[nextIdx];
            nums[nextIdx] = val;
            nextIdx = (nextIdx + k) % n;
            val = tmpVal;
        }
    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 4, 5 };
        int k = 2;

        RotateArray r = new RotateArray();
        r.rotate(nums, k);
        for (int elem : nums) {
            System.out.println(elem);

        }
    }
}
