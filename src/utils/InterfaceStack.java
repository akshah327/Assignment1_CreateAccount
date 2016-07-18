package utils;

/**
 * Created by anujshah on 7/6/16.
 */
public interface InterfaceStack<T>
{
    T top();

    T pop();

    void push(T element);

    boolean isEmpty();

    int size();

    String toString();
}
