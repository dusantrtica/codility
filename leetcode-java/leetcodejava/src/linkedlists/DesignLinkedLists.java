package linkedlists;

class Node {
    public Node next;
    public int val;
}

class MyLinkedList {
    public Node head;
    private int length;

    /** Initialize your data structure here. */
    public MyLinkedList() {
        this.head = null;
        this.length = 0;
    }

    /**
     * Get the value of the index-th node in the linked list. If the index is
     * invalid, return -1.
     */
    public int get(int index) {
        if (index >= length || index < 0) {
            return -1;
        }

        Node curr = head;

        for (int i = 0; i < index; i++) {
            curr = curr.next;
        }

        return curr.val;
    }

    /**
     * Add a node of value val before the first element of the linked list. After
     * the insertion, the new node will be the first node of the linked list.
     */
    public void addAtHead(int val) {
        Node newHead = new Node();
        newHead.val = val;
        newHead.next = this.head;
        this.head = newHead;
        this.length++;
    }

    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        Node tmp = this.head;
        while (tmp.next != null) {
            tmp = tmp.next;
        }

        tmp.next = new Node();
        tmp.next.val = val;
        this.length++;
    }

    /**
     * Add a node of value val before the index-th node in the linked list. If index
     * equals to the length of linked list, the node will be appended to the end of
     * linked list. If index is greater than the length, the node will not be
     * inserted.
     */
    public void addAtIndex(int index, int val) {
        if (index > length || index < 0) {
            return;
        }

        if (index == 0) {
            this.addAtHead(val);
        }

        else if (index == length) {
            Node tmp = this.head;
            while (tmp.next != null) {
                tmp = tmp.next;
            }
            Node newTail = new Node();
            newTail.val = val;
            tmp.next = newTail;
        } else {
            Node tmp = this.head;
            for (int i = 0; i < index - 1; i++) {
                tmp = tmp.next;
            }

            Node newNode = new Node();
            newNode.val = val;
            newNode.next = tmp.next;
            tmp.next = newNode;
        }

        this.length++;
    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if (index >= length || index < 0) {
            return;
        }

        if (index == 0) {
            this.head = this.head.next;
        } else {
            Node tmp = this.head;
            for (int i = 0; i < index - 1; i++) {
                tmp = tmp.next;
                tmp.next = tmp.next.next;
            }
        }
    }
}

public class DesignLinkedLists {

    public static void printList(Node head) {
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }

    public static void main(String[] args) {
        MyLinkedList obj = new MyLinkedList();
        obj.addAtHead(1); // [1]
        obj.addAtTail(3); // [1, 3]
        obj.addAtIndex(1, 2); // [1,3] -> [1, 2, 3]
        System.out.println(obj.get(1));
        obj.deleteAtIndex(1);
        System.out.println(obj.get(1));
    }
}
