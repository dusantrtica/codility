package c2;

import java.util.PriorityQueue;

public class Median {
    private PriorityQueue<Integer> lowHeap = new PriorityQueue<>((o1, o2) -> Integer.compare(o1, o2));
    private PriorityQueue<Integer> highHeap = new PriorityQueue<>((o1, o2) -> Integer.compare(o2, o1));

    private void balance() {
        if(lowHeap.size() > highHeap.size()) {
            while(lowHeap.size() > highHeap.size()) {
                highHeap.add(lowHeap.poll());
            }
        } else if(lowHeap.size() < highHeap.size()) {
            while(lowHeap.size() < highHeap.size()) {
                lowHeap.add(highHeap.poll());
            }
        }
    }

    public void insert(Integer x) {
        lowHeap.add(x);
        balance();
    }

    public int median() {
        int value = !lowHeap.isEmpty() ? lowHeap.poll() : highHeap.poll();
        balance();
        return value;
    }
}
