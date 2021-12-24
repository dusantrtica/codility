package linkedlists;

import java.util.function.Consumer;

public class DoubleLinkedList <T extends Comparable> {
  private DNode<T> head;
  private DNode<T> tail;

  public void insert(T data) {
    DNode<T> node = new DNode<T>(data);
    if(tail == null) {
      tail = node;
      head = node;
    } else {
      tail.setNextNode(node);
      node.setPreviousNode(tail);
      tail = node;
    }
  }

  public void remove(T data) {
    DNode<T> start = head;
    while(start != null) {
      if(start.getData().compareTo(data) == 0) {
        DNode prev = start.getPreviousNode();
        DNode next = start.getNextNode();
        if(prev != null) {
          prev.setNextNode(next);
        } else {
          // head
          head = head.getNextNode();
        }
        if(next != null) {
          next.setPreviousNode(prev);
        } else {
          // tail
          tail = tail.getPreviousNode();
        }
      }
      start = start.getNextNode();
    }
  }

  public void traverseForward() {
    DNode<T> start = head;
    while(start != null) {
      System.out.println(start.getData());
      start = start.getNextNode();
    }
  }

  public void traverse(Consumer<T> consumer) {
    DNode<T> start = head;
    while(start != null) {
      consumer.accept(start.getData());
      start = start.getNextNode();
    }
  }
}
