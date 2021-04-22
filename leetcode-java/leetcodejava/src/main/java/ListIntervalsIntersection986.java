import java.util.Arrays;

public class ListIntervalsIntersection986 {
    private int [] getTntersection(int [] a, int [] b) {
        if(a[0] <= b[1] && b[0] <= a[1]) {
            return new int [] {Math.max(a[0], b[0]), Math.min(a[1], b[1])};
        }
        return null;
    }

    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        int m = firstList.length;
        int n = secondList.length;
        int [][] result = new int[m+n][2];
        if(m == 0 || n == 0) {
            return new int [][]{};
        }
        int i = 0;
        int j = 0;
        int k = 0;

        while(i < m && j < n) {
            int [] intersection = getTntersection(firstList[i], secondList[j]);
            if(intersection != null) {
                result[k++] = intersection;
            }
            if (firstList[i][1] < secondList[j][1]) {
                i++;
            } else if (firstList[i][1] > secondList[j][1]) {
                j++;
            } else {
                i++;
                j++;
            }
        }
        return Arrays.copyOf(result, k);
    }
}
