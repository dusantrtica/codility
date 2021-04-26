package c1.week1;

public class CountInversions {
    private int mergeAndCount(int[] nums, int[] l, int[] r, int lLen, int rLen) {
        int count = 0;
        int i = 0;
        int j = 0;
        int k = 0;

        while (i < lLen && j < rLen) {
            if (l[i] < r[j]) {
                nums[k++] = l[i++];
            } else {
                nums[k++] = r[j++];
                count += (lLen - i);
            }
        }

        while (i < lLen) {
            nums[k++] = l[i++];
        }

        while (j < rLen) {
            nums[k++] = r[j++];
        }
        return count;
    }

    public int countInversions(int[] nums) {
        int n = nums.length;
        if (n < 2) {
            return 0;
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

        int leftInversionCount = countInversions(l);
        int rightInversionCount = countInversions(r);
        int splitInversionCount = mergeAndCount(nums, l, r, mid, n - mid);
        return leftInversionCount + rightInversionCount + splitInversionCount;
    }
}
