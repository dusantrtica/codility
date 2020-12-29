package arrays101;

import java.util.ArrayList;
import java.util.List;

import javax.naming.spi.DirStateFactory.Result;

public class FindAllNumbersDisappearedInArray {
    static void swap(int[] x, int i, int j) {
        int tmp = x[i];
        x[i] = x[j];
        x[j] = tmp;
    }

    public static List<Integer> findDisappearedNumbers(int[] nums) {
        int i = 0;
        int len = nums.length;

        while (i < len) {
            int curr = nums[i];
            if (curr == i + 1 || nums[curr - 1] == curr) {
                i++;
            } else {
                swap(nums, i, curr - 1);
            }
        }

        List<Integer> result = new ArrayList<>();

        for (i = 0; i < len; i++) {
            if (nums[i] != i + 1) {
                result.add(i + 1);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] input = { 4, 3, 2, 7, 8, 2, 3, 1 };
        List<Integer> result = findDisappearedNumbers(input);
        for (int e : result) {
            System.out.println(e);

        }

        input = {3,2,2, 2};
        

        result = findDisappearedNumbers(Arrays.)
    }
}
