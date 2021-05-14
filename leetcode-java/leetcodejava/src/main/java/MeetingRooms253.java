import java.util.Arrays;
import org.junit.Assert;
import org.junit.Test;

public class MeetingRooms253 {

  boolean isIntervalOverlap(int[] a, int[] b) {
    if (a == null || b == null) {
      return false;
    }
    return a[0] < b[1] && b[0] < a[1];
  }

  public int minMeetingRooms(int[][] intervals) {
    int maxOverlappingIntervals = 1;
    int overlappingIntervals = 1;
    Arrays.sort(intervals, (o1, o2) -> Integer.compare(o1[1], o2[1]));
    for (int i = 1; i < intervals.length; i++) {
      if (isIntervalOverlap(intervals[i - 1], intervals[i])) {
        overlappingIntervals++;
      } else {
        if (maxOverlappingIntervals < overlappingIntervals) {
          maxOverlappingIntervals = overlappingIntervals;
        }
        overlappingIntervals = 1;
      }
    }
    return overlappingIntervals > maxOverlappingIntervals ? overlappingIntervals : maxOverlappingIntervals;
  }

  @Test
  public void case1() {
    Assert.assertEquals(2, minMeetingRooms(new int[][]{{0, 30}, {5, 10}, {15, 20}}));
  }

  @Test
  public void case2() {
    Assert.assertEquals(1, minMeetingRooms(new int[][]{{7, 10}, {2, 4}}));
  }

  @Test
  public void case3() {
    Assert.assertEquals(1, minMeetingRooms(new int [][]{{13, 15}, {1, 13}}));
  }

  @Test
  public void case4() {
    Assert.assertEquals(2, minMeetingRooms(new int [][]{{2, 11}, {6, 16}, {11, 16}}));
  }
}
