package c2;

public class Heap {

  int[] data;
  int size;

  public Heap(int maxSize) {
    data = new int[maxSize];
    this.size = 0;
  }

  private void swap(int i, int j) {
    int temp = data[i];
    data[i] = data[j];
    data[j] = temp;
  }

  public int getSize() {
    return size;
  }

  private void balanceBotomUp() {
    int index = size - 1;
    int elem = data[index];

    while (true) {
      int parentIndex = (index-1)/2;
      int parent = data[parentIndex];
      if (parent <= elem) {
        break;
      } else {
        swap(parentIndex, index);
        index = parentIndex;
      }
    }
  }

  private boolean isLeaf(int pos) {
    return (pos * 2) + 1 >= size;
  }

  private void balanceBottomDown() {
    int pos = 0;
    swap(pos, size - 1);
    size--;
    while (!isLeaf(pos)) {
      int childPosToSwapWith = data[2 * pos + 1] <= data[2 * pos + 2] ? 2 * pos + 1 : 2 * pos + 2;
      swap(childPosToSwapWith, pos);
      pos = childPosToSwapWith;
    }
  }

  public void insert(int elem) {
    this.data[size++] = elem;
    balanceBotomUp();
  }

  public int extractMin() {
    int min = data[0];
    balanceBottomDown();
    return min;
  }

  public int getMin() {
    return data[0];
  }
}
