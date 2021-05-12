package week2;

import c2.Heap;
import org.junit.Assert;
import org.junit.Test;

public class HeapSpec {

  @Test
  public void insertOneElement() {
    Heap heap = new Heap(1);
    heap.insert(4);
    Assert.assertEquals(4, heap.extractMin());
    Assert.assertEquals(0, heap.getSize());
  }

  @Test
  public void insert3ElementsSorted() {
    Heap heap = new Heap(3);
    heap.insert(1);
    heap.insert(2);
    heap.insert(3);

    Assert.assertEquals(1, heap.extractMin());
    Assert.assertEquals(2, heap.extractMin());
    Assert.assertEquals(3, heap.extractMin());
  }

  @Test
  public void insertNotSortedElements() {
    Heap heap = new Heap(6);
    heap.insert(5);
    heap.insert(6);
    heap.insert(2);
    heap.insert(3);
    heap.insert(1);
    heap.insert(4);

    Assert.assertEquals(1, heap.extractMin());
    Assert.assertEquals(2, heap.extractMin());
    Assert.assertEquals(3, heap.extractMin());
    Assert.assertEquals(4, heap.extractMin());
    Assert.assertEquals(5, heap.extractMin());
    Assert.assertEquals(6, heap.extractMin());
  }
}
