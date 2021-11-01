package c3;

import java.util.List;
import org.spockframework.util.Pair;

public class Knapsack {
  int safeGet(int [][]A, int i, int j) {
    if(i < 0 || j < 0) {
      return 0;
    }
    return A[i][j];
  }
  public int knapsack(int W, List<Pair<Integer, Integer>> items) {
    int n = items.size();
    int [][]A = new int [W][n];
    for(int i = 0; i < n; i++) {
      for(int x = 0; x < W; x++) {
        int value = items.get(i).first();
        int weight = items.get(i).second();
        if(weight > x) {
          A[x][i] = 0;
        } else {
          A[x][i] = Math.max(safeGet(A, x, i-1), value + safeGet(A, x-weight, i-1));
        }
      }
    }
    return A[W-1][n-1];
  }
}
