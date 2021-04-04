public class ShuffleArray1470 {
    public int[] shuffle(int[] nums, int n) {
        int [] result = new int[nums.length];
        int j = 0;
        for(int i = 0; i < nums.length /2 ; i++) {
            result[j++] = nums[i];
            result[j++] = nums[i + n];
        }

        return result;
    }
}
