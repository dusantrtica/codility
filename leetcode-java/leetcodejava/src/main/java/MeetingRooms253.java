import java.util.Arrays;
import java.util.PriorityQueue;

import org.junit.Assert;
import org.junit.Test;

public class MeetingRooms253 {
  public int minMeetingRooms(int[][] intervals) {
    if(intervals.length == 0) {
      return 0;
    }
    PriorityQueue<Integer> rooms = new PriorityQueue<>();
    Arrays.sort(intervals, (o1, o2) -> Integer.compare(o1[0], o2[0]));
    rooms.add(intervals[0][1]);

    for(int i = 1; i < intervals.length; i++) {
      if(intervals[i][0] >= rooms.peek()) {
        rooms.poll();
      }
      rooms.add(intervals[i][1]);
    }

    return rooms.size();
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

  @Test
  public void case5() { Assert.assertEquals(1, minMeetingRooms(new int [][]{{2,7}}));}

  @Test
  public void case6() { Assert.assertEquals(2, minMeetingRooms(new int[][]{{5, 8}, {6, 8}}));}
}
