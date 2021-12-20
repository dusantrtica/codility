package linkedlists;

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

    }

    @Override
    public void traverse() {
        if(root == null) {
            return;
        }

        Node actualNode = root;
        while(actualNode.getNextNode() != null) {
            System.out.println(actualNode);
            actualNode = actualNode.getNextNode();
        }
    }

    @Override
    public int size() {
        return 0;
    }
}
