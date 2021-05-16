import org.junit.Assert;
import org.junit.Test;

import java.util.PriorityQueue;

public class FindMedianDataStream295 {
    class MedianFinder {

        private final PriorityQueue<Integer> lowHeap = new PriorityQueue<>((o1, o2) -> Integer.compare(o2, o1));
        private final PriorityQueue<Integer> highHeap = new PriorityQueue<>((o1, o2) -> Integer.compare(o1, o2));


        /**
         * initialize your data structure here.
         */
        public MedianFinder() {

        }

        private void balance() {
            if (lowHeap.size() > highHeap.size() + 1) {
                while (lowHeap.size() > highHeap.size() + 1) {
                    highHeap.add(lowHeap.poll());
                }
            } else if (highHeap.size() > lowHeap.size() + 1) {
                while(highHeap.size() > lowHeap.size() + 1) {
                    lowHeap.add(highHeap.poll());
                }
            }
        }

        public void addNum(int num) {
            if(highHeap.size() > 0 && num > highHeap.peek()) {
                highHeap.add(num);
            } else {
                lowHeap.add(num);
            }

            balance();
        }

        public double findMedian() {
            int totalSize = lowHeap.size() + highHeap.size();
            if (totalSize % 2 == 1) {
                return lowHeap.size() > highHeap.size() ? lowHeap.peek() : highHeap.peek();
            }

            return (lowHeap.peek() + highHeap.peek()) / 2.;
        }
    }

    @Test
    public void case1() {
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(1);
        medianFinder.addNum(2);
        Assert.assertEquals(1.5, medianFinder.findMedian(), 0.1);
    }

    @Test
    public void case2() {
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(-1);
        Assert.assertEquals(-1, medianFinder.findMedian(), 0.1);
        medianFinder.addNum(-2);
        Assert.assertEquals(-1.5, medianFinder.findMedian(), 0.1);
        medianFinder.addNum(-3);
        Assert.assertEquals(-2, medianFinder.findMedian(), 0.1);
        medianFinder.addNum(-4);
        Assert.assertEquals(-2.5, medianFinder.findMedian(), 0.1);
        medianFinder.addNum(-5);
        Assert.assertEquals(-3, medianFinder.findMedian(), 0.1);
    }

    @Test
    public void case3() {
        MedianFinder medianFinder =new MedianFinder();
        medianFinder.addNum(1);
        medianFinder.addNum(2);
        Assert.assertEquals(1.5, medianFinder.findMedian(), 0.1);
        medianFinder.addNum(3);
        Assert.assertEquals(2, medianFinder.findMedian(), 0.1);
    }
}
