package linkedlists;

public interface List<T extends  Comparable<T>> {
    void insert(T data);

    void remove(T data);

    void traverse();

    int size();
}
