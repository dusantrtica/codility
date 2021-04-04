import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MergeIntervals56 {
    boolean isIntervalOverlap(int[] a, int[] b) {
        if (a == null || b == null) {
            return false;
        }
        return a[0] <= b[1] && b[0] <= a[1];
    }

    public int[][] merge(int[][] intervals) {

        List<int[]> result = new ArrayList<>();

        Arrays.sort(intervals, (o1, o2) -> {
            return o1[0] - o2[0];
        });

        int[] intervalToAdd = null;

        for (int[] interval : intervals) {
            if (isIntervalOverlap(interval, intervalToAdd)) {
                intervalToAdd[1] = Math.max(intervalToAdd[1], interval[1]);

            } else {
                intervalToAdd = interval;
                result.add(intervalToAdd);
            }
        }

        int [][] array = new int[result.size()][2];
        int i = 0;
        for(int[] r : result) {
            array[i++] = r;
        }

        return array;
    }
}
