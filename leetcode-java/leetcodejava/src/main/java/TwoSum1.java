import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;

public class TwoSum1 {
    public int [] twoSum(int [] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int [] result = new int [2];
        int index = 0;
        for(int i = 0; i < nums.length; i++) {
            if(map.containsKey(target - nums[i])) {
                result[0] = map.get(target - nums[i]);
                result[1] = i;
            }
            map.put(nums[i], i);
        }
        return result;
    }

    @Test
    public void case1() {
        Assert.assertArrayEquals(new int []{0,1}, twoSum(new int []{2,7,11,15}, 9));
    }

    @Test
    public void case2() {
        Assert.assertArrayEquals(new int []{1, 2}, twoSum(new int []{3,2,4}, 6));
    }

    @Test
    public void case3() {
        Assert.assertArrayEquals(new int []{0,1}, twoSum(new int []{3, 3},6));
    }
}
