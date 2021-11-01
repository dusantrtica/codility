package c3;

public class PathDP {

  public int maxWeightPathNoAdj(int[] nums) {
    int n = nums.length;
    int[] A = new int[nums.length];
    A[0] = nums[0];
    A[1] = Math.max(nums[0], nums[1]);
    for(int i = 2; i < n; i++) {
      A[i] = Math.max(A[i-1], A[i-2]+ nums[i]);
    }
    return A[A.length-1];
  }
}
