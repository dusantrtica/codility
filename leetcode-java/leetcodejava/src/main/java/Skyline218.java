import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Skyline218 {

  public List<List<Integer>> getSkyline(int[][] buildings) {
    PriorityQueue<Integer[]> pointsByRightEnd = new PriorityQueue<>((p1, p2) -> {
      return Integer.compare(p1[1], p2[1]);
    });

    List<List<Integer>> result = new ArrayList<>();
    int currHeight = 0;

    if (buildings.length == 0) {
      return result;
    }

    for(int i = 0; i < buildings.length; i++) {

    }

    return result;
  }
}
