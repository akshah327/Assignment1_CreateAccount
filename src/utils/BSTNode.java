package utils;

/**
 * Created by anujshah on 7/20/16.
 */
public class BSTNode<T extends Comparable<T>>
{
    private T element;
    private BSTNode<T> left;
    private BSTNode<T> right;

    public BSTNode(T element)
    {
        this.element = element;
        this.left = null;
        this.right = null;
    }

    public T getElement()
    {
        return element;
    }

    public BSTNode<T> getRight()
    {
        return right;
    }

    public BSTNode<T> getLeft()
    {
        return left;
    }

    public void setElement(T element)
    {
        this.element = element;
    }

    public void setLeft(BSTNode<T> left)
    {
        this.left = left;
    }

    public void setRight(BSTNode<T> right)
    {
        this.right = right;
    }
}
