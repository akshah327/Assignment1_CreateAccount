package utils;

/**
 * Created by anujshah on 7/20/16.
 */
public interface InterfaceBST<T extends Comparable<T>>
{
    static final int PREORDER = 1;
    static final int INORDER = 2;
    static final int POSTORDER = 3;

    void add(T element);

    boolean remove(T element);

    boolean contains(T element);

    boolean isEmpty();

    int size();

    int reset(int orderType);

    T get(T element);

    T getNext(int orderType);

    String toString();

}
