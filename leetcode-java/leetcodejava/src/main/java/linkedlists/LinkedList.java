package linkedlists;

import java.util.function.Consumer;

public class LinkedList <T extends Comparable<T>> implements List<T> {
    private Node<T> root;
    private int numOfItems;
    @Override
    public void insert(T data) {
        if(root == null) {
            root = new Node<>(data);
        } else {
            insertBeginning(data);
        }
    }

    private void insertBeginning(T data) {
        Node newStart = new Node<T>(data);
        newStart.setNextNode(root);
        root = newStart;
    }

    private void insertEnd(T data) {
        Node last = root;
        while(last.getNextNode() != null) {
            last.setNextNode(last.getNextNode());
        }
        Node newEnd = new Node<>(data);
        last.setNextNode(newEnd);
    }

    private void insertEnd(T data, Node<T> node) {
        if(node.getNextNode() != null) {
            insertEnd(data, node.getNextNode());
        } else {
            Node newEnd = new Node<>(data);
            node.setNextNode(newEnd);
        }
    }

    @Override
    public void remove(T data) {
        if(root == null) {
            return;
        }
        if(root.getData().compareTo(data) == 0) {
            root = root.getNextNode();
        } else {
            remove(data, root, root.getNextNode());
        }
    }

    private void remove(T data, Node<T> previousNode, Node<T> actualNode) {
        while(actualNode != null) {
            if(actualNode.getData().compareTo(data) == 0) {
                numOfItems --;
                previousNode.setNextNode(actualNode.getNextNode());
            }
            previousNode = actualNode;
            actualNode = actualNode.getNextNode();
        }
    }

    @Override
    public void traverse() {
        if(root == null) {
            return;
        }

        Node actualNode = root;
        while(actualNode != null) {
            System.out.println(actualNode);
            actualNode = actualNode.getNextNode();
        }
    }

    public void traverse(Consumer<T> consumer) {
        Node actualNode = root;
        while(actualNode != null) {
            consumer.accept((T)actualNode.getData());
            actualNode = actualNode.getNextNode();
        }
    }

    public T midElement() {
        if(root == null) {
            return null;
        }
        Node actualNode = root;
        Node nextNode = root.getNextNode();

        while(nextNode != null) {
            actualNode = actualNode.getNextNode();
            nextNode = actualNode.getNextNode();
            if(nextNode != null) {
                nextNode = nextNode.getNextNode();
            }
        }
        return (T)actualNode.getData();
    }

    public void reverse() {
        if(root == null || root.getNextNode() == null) {
            return;
        }

        Node<T> curr = root;
        while(curr.getNextNode() != null) {
            Node<T> next = curr.getNextNode();
            Node<T> tmp = next.getNextNode();
            next.setNextNode(curr);
        }
        root = curr;
    }

    @Override
    public int size() {
        return 0;
    }
}
