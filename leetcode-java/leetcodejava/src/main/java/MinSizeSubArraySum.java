public class MinSizeSubArraySum {
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int l = 0; // low pointer
        int h = 0; // high pointer
        int min = n; // initial
        int c = 0;
        int s = 0; // keeps track of sum

        boolean found = false;

        while (l < n) {
            while (h < n) {
                s += nums[h];
                if (s >= target) {
                    c = h - l + 1; // distance
                    min = c < min ? c : min;
                    found = true;
                    break;
                }
                h++;
            }

            while (l < n) {
                s -= nums[l];
                l++;
                if (s >= target) {
                    c = h - l + 1;
                    min = c < min ? c : min;
                } else {
                    break;
                }
            }

            h++;
        }

        return found ? min : 0;
    }

    public static void main(String[] args) {
        MinSizeSubArraySum m = new MinSizeSubArraySum();
        int[] nums = { 2, 3, 1, 2, 4, 3 };
        int target = 7;
        int res = m.minSubArrayLen(target, nums);
        System.out.println(res);
        ;
    }
}
