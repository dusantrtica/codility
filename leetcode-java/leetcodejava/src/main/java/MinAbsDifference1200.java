import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinAbsDifference1200 {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        int n = arr.length;
        Arrays.sort(arr);
        int minDiff = Math.abs(arr[0] - arr[n - 1]);
        for (int i = 0; i < n - 1; i++) {
            if (Math.abs(arr[i] - arr[i + 1]) < minDiff) {
                minDiff = Math.abs(arr[i] - arr[i + 1]);
            }
        }

        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < n - 1; i++) {
            if (Math.abs(arr[i] - arr[i + 1]) == minDiff) {
                result.add(Arrays.asList(arr[i], arr[i + 1]));
            }
        }
        return result;
    }
}
