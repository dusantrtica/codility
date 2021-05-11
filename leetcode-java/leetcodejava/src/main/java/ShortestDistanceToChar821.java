import org.junit.Assert;
import org.junit.Test;

public class ShortestDistanceToChar821 {
    public int[] shortestToChar(String ss, char c) {
        char[] s = ss.toCharArray();
        int n = s.length;
        int[] result = new int[n];
        int maxDistance = 10001;
        for (int i = 0; i < n; i++) {
            if (s[i] == c) {
                maxDistance = i;
            }
            result[i] = Math.abs(i - maxDistance);
        }

        maxDistance = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (s[i] == c) {
                maxDistance = i;
            }
            result[i] = Math.min(result[i], Math.abs(i - maxDistance));
        }

        return result;
    }

    public int[] shortestToChar_(String ss, char c) {
        char[] s = ss.toCharArray();
        int n = s.length;
        int[] result = new int[n];
        int cCount = 0;
        for (int i = 0; i < n; i++) {
            if (s[i] == c) {
                cCount++;
            }
        }
        int[] cPositions = new int[cCount];
        int k = 0;
        for (int i = 0; i < n; i++) {
            if (s[i] == c) {
                cPositions[k++] = i;
            }
        }
        for (int i = 0; i < n; i++) {
            if (s[i] == c) {
                result[i] = 0;
            } else {
                int minDistance = Math.abs(i - cPositions[0]);
                for (int j = 1; j < cCount; j++) {
                    int abs = Math.abs(i - cPositions[j]);
                    if (abs < minDistance) {
                        minDistance = abs;
                    }
                }
                result[i] = minDistance;
            }
        }
        return result;
    }

    @Test
    public void case1() {
        String s = "loveleetcode";
        char c = 'e';
        Assert.assertArrayEquals(new int[]{3, 2, 1, 0, 1, 0, 0, 1, 2, 2, 1, 0}, shortestToChar(s, c));
    }

    @Test
    public void case2() {
        String s = "aaab";
        char c = 'b';
        Assert.assertArrayEquals(new int[]{3, 2, 1, 0}, shortestToChar(s, c));
    }

    @Test
    public void case3() {
        String s = "bbba";
        char c = 'b';
        Assert.assertArrayEquals(new int[]{0, 0, 0, 1}, shortestToChar(s, c));
    }
}
