package utils;

/**
 * Created by anujshah on 7/20/16.
 */

public class BinarySearchTree<T extends Comparable<T>> implements InterfaceBST<T>
{
    private BSTNode<T> root;
    private boolean found;

    private LinkedListQueue<T> inOrderQueue;
    private LinkedListQueue<T> preOrderQueue;
    private LinkedListQueue<T> postOrderQueue;
    private LinkedListQueue<T> queueToPrint;

    public BinarySearchTree()
    {
        root = null;
    }

    @Override
    public void add(T element)
    {
        root = recAdd(element, root);
    }

    private BSTNode<T> recAdd(T element, BSTNode<T> tree)
    {
        if (tree == null)
            tree = new BSTNode<T>(element);
        else if(element.compareTo(tree.getElement()) <= 0)
            tree.setLeft(recAdd(element, tree.getLeft()));
        else
            tree.setRight(recAdd(element, tree.getRight()));
        return tree;
    }

    @Override
    public boolean remove(T element)
    {
        root = recRemove(element, root);
        return true;
    }

    private BSTNode<T> recRemove(T element, BSTNode<T> tree)
    {
    //This method uses a recursive call to identify the node for removal.
    //  It navigates through the list, going to left or rught subtrees
    //  depending on whether the tree element is greater than or less than
    //  the element we are looking for.
    //This method is pretty similar to the contains method, but once we
    //  find the node we want to remove, we call on our next helper method.
        if (tree == null)
            found = false;
        else if (element.compareTo(tree.getElement()) < 0)
            tree.setLeft(recRemove(element, tree.getLeft()));
        else if (element.compareTo(tree.getElement()) > 0)
            tree.setRight(recRemove(element, tree.getRight()));
        else
            tree = removeNode(tree);
            found = true;
        return tree;
    }

    private BSTNode<T> removeNode(BSTNode<T> tree)
    //We already checked for a tree that has no children in the recRemove method, so
    //  it's not necessary to check here. We can go straight to checking whether the
    //  node we want to remove has a left child, right child, or both
    //We also don't need to check for a leaf specifically, because the if statement
    //  inherently checks for a leaf (if left is null, it returns right, and if
    //  right is also null, it simply returns null).
    {
        T data;

        if (tree.getLeft() == null)
            return tree.getRight();
        else if (tree.getRight() == null)
            return tree.getLeft();
        else
        {
            data = getPredecessor(tree.getLeft());
            tree.setElement(data);
            tree.setLeft(recRemove(data, tree.getLeft()));
            return tree;
        }
    }

    private T getPredecessor(BSTNode<T> tree)
    {
    //This method is necessary when the node has two children, and we have to
    //  replace it with the highest value on the left subtree
        while (tree.getRight() != null)
        {
            tree = tree.getRight();
        }
        return tree.getElement();
    }

    @Override
    public boolean contains(T element)
    {
        return recContains(element, root);
    }

    private boolean recContains(T element, BSTNode<T> tree)
    {
        if (tree == null)
            return false;
        else if (element.compareTo(tree.getElement()) < 0)
            return recContains(element, tree.getLeft());
        else if (element.compareTo(tree.getElement()) > 0)
            return recContains(element, tree.getRight());
        else
            return true;
    }

    @Override
    public boolean isEmpty()
    {
        return (root == null);
    }

    @Override
    public int size()
    {
        return recSize(root);
    }

    private int recSize(BSTNode<T> tree)
    {
        if (tree == null)
            return 0;
        else
            return recSize(tree.getLeft()) + recSize(tree.getRight()) + 1;
    }

    public int reset(int orderType)
    {
        int numNodes = size();
        if (orderType == INORDER)
        {
            inOrderQueue = new LinkedListQueue<T>();
            inOrder(root);
        }
        if (orderType == PREORDER)
        {
            preOrderQueue = new LinkedListQueue<T>();
            preOrder(root);
        }
        if (orderType == POSTORDER)
        {
            postOrderQueue = new LinkedListQueue<T>();
            postOrder(root);
        }
        return numNodes;
    }

    private void inOrder(BSTNode<T> tree)
    {
        if (tree != null)
        {
            inOrder(tree.getLeft());
            inOrderQueue.insertInQueue(tree.getElement());
            inOrder(tree.getRight());
            queueToPrint = inOrderQueue;
        }
    }

    private void preOrder(BSTNode<T> tree)
    {
        if (tree != null)
        {
            preOrderQueue.insertInQueue(tree.getElement());
            preOrder(tree.getLeft());
            preOrder(tree.getRight());
            queueToPrint = preOrderQueue;
        }
    }

    private void postOrder(BSTNode<T> tree)
    {
        if (tree != null)
        {
            postOrder(tree.getLeft());
            postOrder(tree.getRight());
            postOrderQueue.insertInQueue(tree.getElement());
            queueToPrint = postOrderQueue;
        }
    }

    public T get(T element)
    {
        return recGet(element, root);
    }

    private T recGet(T element, BSTNode<T> tree)
    {
        if (tree == null)
            return null;
        else if (element.compareTo(tree.getElement()) < 0)
            return recGet(element, tree.getLeft());
        else if (element.compareTo(tree.getElement()) > 0)
            return recGet(element, tree.getRight());
        else
            return tree.getElement();
    }

    public T getNext(int orderType)
    {
        if (orderType == INORDER)
            return inOrderQueue.deQueue();
        else if (orderType == PREORDER)
            return preOrderQueue.deQueue();
        else if (orderType == POSTORDER)
            return postOrderQueue.deQueue();
        else
            return null;
    }

    public String toString()
    {
        inOrder(root);
        return queueToPrint.toString();
    }
}
