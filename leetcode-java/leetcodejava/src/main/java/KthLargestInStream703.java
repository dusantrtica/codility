import java.util.PriorityQueue;
import org.junit.Assert;
import org.junit.Test;

public class KthLargestInStream703 {

  @Test
  public void case1() {
    KthLargest kthLargest = new KthLargest(3, new int[]{4, 5, 8, 2});
    Assert.assertEquals(4, kthLargest.add(4));
    Assert.assertEquals(5, kthLargest.add(5));
    Assert.assertEquals(5, kthLargest.add(10));
    Assert.assertEquals(8, kthLargest.add(9));
    Assert.assertEquals(8, kthLargest.add(4));
  }

  class KthLargest {

    private final PriorityQueue<Integer> queue;
    private final int k;

    public KthLargest(int k, int[] nums) {
      queue = new PriorityQueue<>((o1, o2) -> Integer.compare(o1, o2));
      this.k = k;
      for (int elem : nums) {
        this.queue.add(elem);
      }
      while (queue.size() > k) {
        queue.poll();
      }
    }

    public int add(int val) {
      queue.add(val);

      while (queue.size() > k) {
        queue.poll();
      }

      return queue.peek();
    }
  }
}