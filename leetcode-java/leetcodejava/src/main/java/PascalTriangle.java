import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {
    // private final List<List<Integer>> matrix = new ArrayList<>();

    public List<List<Integer>> generate(int numRows) {
        int[][] nums = new int[numRows][numRows];
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numRows; j++) {
                if (i == 0 || j == 0) {
                    nums[i][j] = 1;
                    continue;
                }
                nums[i][j] = nums[i - 1][j] + nums[i][j - 1];
            }
        }

        List<List<Integer>> result = new ArrayList<>(numRows);

        for (int k = 0; k < numRows; k++) {
            List<Integer> newRow = new ArrayList<>(k+1);
            for (int i = 0; i <= k; i++) {
                for (int j = 0; j <= k; j++) {
                    if (i + j == k) {
                        newRow.add(nums[i][j]);
                    }
                }
            }
            result.add(newRow);
        }

        return result;
    }

    public void printLists(List<List<Integer>> triangle) {
        for (List<Integer> row : triangle) {
            for (int elem : row) {
                System.out.print(elem);
                System.out.print(" ");
            }
            System.out.println();
        }
    }

    @Test
    public void test1() {
//    printLists(generate(1));
//
//    printLists(generate(2));
//
//    printLists(generate(4));

        printLists(generate(5));
    }
}
