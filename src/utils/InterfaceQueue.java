package utils;

/**
 * Created by anujshah on 7/6/16.
 */
public interface InterfaceQueue<T>
{
    public void insertInQueue(T element);

    public T deQueue();

    public boolean isEmpty();

    int size();

    String toString();
}
