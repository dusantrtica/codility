public class RunningSumOf1dArray1480 {
  public int [] runningSum(int [] nums) {
    int [] result = new int [nums.length];
    int n = nums.length;

    result[0] = nums[0];
    for(int i = 1; i < n; i++) {
      result[i] = result[i-1] + nums[i];
    }

    return result;
  }
}
