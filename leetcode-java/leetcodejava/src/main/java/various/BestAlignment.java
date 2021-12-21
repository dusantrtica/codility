package various;

import org.junit.Assert;
import org.junit.Test;

public class BestAlignment {
  int penaltyForChars(int i, int j, String s, String t, int penaltyPrice) {
    if(s.length() < i || t.length() < j) {
      return penaltyPrice;
    }
    char ss = s.charAt(i);
    char tt = t.charAt(j);

    return ss == tt ? 0 : penaltyPrice;
  }

  int[][] generateAndInitializeResultMatrix(
      int len1, int len2, int penaltyPrice) {
    int[][] A = new int[len1 + 1][len2 + 1];
    A[0][0] = 0;
    for (int i = 1; i <= len1; i++) {
      A[i][0] = i*penaltyPrice;
    }
    for(int i = 1; i <= len2; i++){
      A[0][i] = i*penaltyPrice;
    }

    return A;
  }

  int bestOfThreeCases(int x, int y, int z) {
    return Math.max(Math.max(x, y), z);
  }

  int bestAlignment(String s1, String s2) {
    final int penaltyPrice = -1;
    final int len1 = s1.length();
    final int len2 = s2.length();
    final int len = Math.max(len1, len2);

    int [][]A = generateAndInitializeResultMatrix(len1, len2, penaltyPrice);

    for(int i = 1; i < len1; i++) {
      for(int j = 1; j < len2; j++) {
        int case1 = penaltyForChars(i, j, s1, s2, penaltyPrice) + A[i-1][j-1];
        int case2 = A[i-1][j] + penaltyPrice;
        int case3 = A[i][j-1] + penaltyPrice;
        A[i][j] = bestOfThreeCases(case1, case2, case3);
      }
    }

    return A[len1][len2];
  }
  @Test
  public void case1() {
    Assert.assertEquals(0, bestAlignment("dusan", "dusan"));
  }

  public void case2 () {
    Assert.assertEquals(2, bestAlignment("acccga", "accgt"));
  }
}
